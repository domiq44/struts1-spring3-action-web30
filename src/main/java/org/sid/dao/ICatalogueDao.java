package org.sid.dao;

import java.util.List;

import org.sid.entities.Produit;

public interface ICatalogueDao {
	void addProduit(Produit p);
	List<Produit> listProduits();
	Produit getProduit(String ref);
	void deleteProduit(String ref);
	void updateProduit(Produit p);
}
