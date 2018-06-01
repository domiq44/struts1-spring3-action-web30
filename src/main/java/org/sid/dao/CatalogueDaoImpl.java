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
		addProduit(new Produit("AAAA", "ABCD", 9800, 5, true));
		addProduit(new Produit("BBBB", "POUY", 7600, 4, true));
		addProduit(new Produit("CCCC", "SDERK", 3466, 7, true));
		addProduit(new Produit("DDDD", "ABCD", 9800, 5, true));
		addProduit(new Produit("EEEE", "POUY", 7600, 4, true));
		addProduit(new Produit("FFFF", "SDERK", 3466, 7, true));
		addProduit(new Produit("GGGG", "ABCD", 9800, 5, true));
		addProduit(new Produit("HHHH", "POUY", 7600, 4, true));
		addProduit(new Produit("IIII", "SDERK", 3466, 7, true));
		addProduit(new Produit("JJJJ", "ABCD", 9800, 5, true));
		addProduit(new Produit("KKKK", "POUY", 7600, 4, true));
		addProduit(new Produit("LLLL", "SDERK", 3466, 7, true));
	}
}
