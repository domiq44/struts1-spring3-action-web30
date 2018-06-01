package org.sid.service;

import java.util.List;

import org.sid.dao.ICatalogueDao;
import org.sid.entities.Produit;
import org.sid.page.Page;
import org.sid.page.PageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogueServiceImpl implements ICatalogueService {

	@Autowired
	private ICatalogueDao dao;

	@Override
	public void addProduit(Produit p) {
		dao.addProduit(p);
	}

	@Override
	public List<Produit> listProduits() {
		return dao.listProduits();
	}

	@Override
	public Page<Produit> newPageRequest(int page, int size) {
		List<Produit> list = dao.listProduits();
		int offset = size * (page - 1);
		return new PageImpl<Produit>(list, offset, size);
	}

	@Override
	public Produit getProduit(String ref) {
		return dao.getProduit(ref);
	}

	@Override
	public void deleteProduit(String ref) {
		dao.deleteProduit(ref);
	}

	@Override
	public void updateProduit(Produit p) {
		dao.updateProduit(p);
	}
}
