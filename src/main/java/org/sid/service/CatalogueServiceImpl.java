package org.sid.service;

import java.util.List;

import org.sid.dao.ICatalogueDao;
import org.sid.entities.Produit;
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
