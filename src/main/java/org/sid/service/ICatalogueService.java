package org.sid.service;

import java.util.List;

import org.sid.entities.Produit;

public interface ICatalogueService {
	void addProduit(Produit p);
	List<Produit> listProduits();
	Produit getProduit(String ref);
	void deleteProduit(String ref);
	void updateProduit(Produit p);
}
