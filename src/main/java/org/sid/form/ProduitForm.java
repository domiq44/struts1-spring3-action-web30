package org.sid.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.util.StringUtils;

public class ProduitForm extends ActionForm {
	private static final long serialVersionUID = -7676581345118986380L;

	private String reference;
	private String designation;
	private double prix;
	private int quantite;
	private boolean promo = false;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isPromo() {
		return promo;
	}

	public void setPromo(boolean promo) {
		this.promo = promo;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		int referenceSizeMin = 4;
		int referenceSizeMax = 10;
		if (!StringUtils.hasText(reference)) {
			errors.add("reference", new ActionMessage("error.reference.required"));
		} else if (reference.length() < referenceSizeMin || reference.length() > referenceSizeMax) {
			errors.add("reference", new ActionMessage("error.reference.invalid", referenceSizeMin, referenceSizeMax));
		}

		if (!StringUtils.hasText(designation)) {
			errors.add("designation", new ActionMessage("error.designation.required"));
		}

		double prixMinValue = 1.0;
		double prixMaxValue = 100000.0;
		if (prix < prixMinValue || prix > prixMaxValue) {
			errors.add("prix", new ActionMessage("error.prix.invalid", prixMinValue, prixMaxValue));
		}

		int quantiteMinValue = 1;
		int quantiteMaxValue = 500;
		if (quantite < quantiteMinValue || quantite > quantiteMaxValue) {
			errors.add("quantite", new ActionMessage("error.quantite.invalid", quantiteMinValue, quantiteMaxValue));
		}

		return errors;
	}
}
