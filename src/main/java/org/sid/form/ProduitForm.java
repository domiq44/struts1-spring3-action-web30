package org.sid.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.sid.entities.Produit;
import org.sid.page.Page;
import org.springframework.util.StringUtils;

public class ProduitForm extends ActionForm {
	private static final long serialVersionUID = -7676581345118986380L;

	private Produit produit = new Produit();
	private Page<Produit> pages;
	private boolean editMode;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Page<Produit> getPages() {
		return pages;
	}

	public void setPages(Page<Produit> pages) {
		this.pages = pages;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		int referenceSizeMin = 4;
		int referenceSizeMax = 10;
		if (!StringUtils.hasText(produit.getReference())) {
			errors.add("reference", new ActionMessage("error.reference.required"));
		} else if (produit.getReference().length() < referenceSizeMin || produit.getReference().length() > referenceSizeMax) {
			errors.add("reference", new ActionMessage("error.reference.invalid", referenceSizeMin, referenceSizeMax));
		}

		if (!StringUtils.hasText(produit.getDesignation())) {
			errors.add("designation", new ActionMessage("error.designation.required"));
		}

		double prixMinValue = 1.0;
		double prixMaxValue = 100000.0;
		if (produit.getPrix() < prixMinValue || produit.getPrix() > prixMaxValue) {
			errors.add("prix", new ActionMessage("error.prix.invalid", prixMinValue, prixMaxValue));
		}

		int quantiteMinValue = 1;
		int quantiteMaxValue = 500;
		if (produit.getQuantite() < quantiteMinValue || produit.getQuantite() > quantiteMaxValue) {
			errors.add("quantite", new ActionMessage("error.quantite.invalid", quantiteMinValue, quantiteMaxValue));
		}

		return errors;
	}
}
