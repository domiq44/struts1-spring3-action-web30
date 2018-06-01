package org.sid.page;

import java.util.Collection;
import java.util.List;

public interface Page<T> {
	List<T> getList();
	int getOffset();
	int getSize();
	int getNumber();
	List<T> getContent();
	int getTotalElements();
	int getTotalPages();
	Collection<Integer> getPagesNo();
}
