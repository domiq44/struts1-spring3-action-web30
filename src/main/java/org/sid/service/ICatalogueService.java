package org.sid.service;

import java.util.List;

import org.sid.entities.Produit;
import org.sid.page.Page;

public interface ICatalogueService {
	void addProduit(Produit p);
	List<Produit> listProduits();
	Page<Produit> newPageRequest(int page, int size);
	Produit getProduit(String ref);
	void deleteProduit(String ref);
	void updateProduit(Produit p);
}
