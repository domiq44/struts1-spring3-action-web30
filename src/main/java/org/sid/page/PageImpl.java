package org.sid.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PageImpl<T> implements Page<T> {

	private List<T> content = new ArrayList<T>();
	private int offset;
	private int length;

	public PageImpl(List<T> content, int offset, int length) {
		this.content.addAll(content);
		this.offset = offset;
		this.length = length;
	}

	@Override
	public List<T> getList() {
		return content;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public int getSize() {
		return length;
	}

	@Override
	public int getNumber() {
		return 1 + (this.offset / this.length);
	}

	@Override
	public List<T> getContent() {
		List<T> newList = new ArrayList<T>();
		int to = this.offset + this.length;
		if (this.offset > content.size()) {
			this.offset = content.size();
		}
		if (to > content.size()) {
			to = content.size();
		}
		for (int i = this.offset; i < to; i++) {
			newList.add(content.get(i));
		}
		return newList;
	}

	@Override
	public int getTotalElements() {
		return content.size();
	}

	@Override
	public int getTotalPages() {
		int pages = content.size() / this.length;
		if (content.size() % this.length != 0) {
			pages++;
		}
		return pages;
	}

	@Override
	public Collection<Integer> getPagesNo() {
		Collection<Integer> collection = new ArrayList<Integer>();
		for (int i = 1; i <= getTotalPages(); i++) {
			collection.add(new Integer(i));
		}
		return collection;
	}
}
