package org.sid.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.sid.entities.Produit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogueDaoImpl implements ICatalogueDao {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogueDaoImpl.class);

	private Map<String, Produit> produits = new HashMap<String, Produit>();

	@Override
	public void addProduit(Produit p) {
		produits.put(p.getReference(), p);
	}

	@Override
	public List<Produit> listProduits() {
		return new ArrayList<Produit>(produits.values());
	}

	@Override
	public Produit getProduit(String ref) {
		return produits.get(ref);
	}

	@Override
	public void deleteProduit(String ref) {
		produits.remove(ref);
	}

	@Override
	public void updateProduit(Produit p) {
		produits.put(p.getReference(), p);
	}

	@PostConstruct
	public void initialisation() {
		LOG.info("Initialisation des produits");
		addProduit(new Produit("ABCD", "ABCD", 9800, 5, true));
		addProduit(new Produit("XYWS", "POUY", 7600, 4, true));
		addProduit(new Produit("ZERT", "SDERK", 3466, 7, true));
	}
}
