package org.sid.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sid.entities.Produit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogueDaoImpl implements ICatalogueDao, InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogueDaoImpl.class);

	private final Map<String, Produit> produits = new HashMap<>();

	@Override
	public void addProduit(Produit p) {
		produits.put(p.getReference(), p);
	}

	@Override
	public List<Produit> listProduits() {
		return getSortedProducts(new ArrayList<>(produits.values()));
	}

	private List<Produit> getSortedProducts(List<Produit> list) {
		Collections.sort(list, new Comparator<Produit>() {
			@Override
			public int compare(Produit p1, Produit p2) {
				return p1.getReference().compareTo(p2.getReference());
			}
		});
		return list;
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

	@Override
	public void afterPropertiesSet() throws Exception {
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
		addProduit(new Produit("MMMM", "ABCD", 9800, 5, true));
		addProduit(new Produit("NNNN", "POUY", 7600, 4, true));
		addProduit(new Produit("OOOO", "SDERK", 3466, 7, true));
		addProduit(new Produit("PPPP", "ABCD", 9800, 5, true));
		addProduit(new Produit("QQQQ", "POUY", 7600, 4, true));
		addProduit(new Produit("RRRR", "SDERK", 3466, 7, true));
		addProduit(new Produit("SSSS", "ABCD", 9800, 5, true));
		addProduit(new Produit("TTTT", "POUY", 7600, 4, true));
		addProduit(new Produit("UUUU", "SDERK", 3466, 7, true));
		addProduit(new Produit("VVVV", "ABCD", 9800, 5, true));
		addProduit(new Produit("WWWW", "POUY", 7600, 4, true));
		addProduit(new Produit("XXXX", "SDERK", 3466, 7, true));
	}
}
