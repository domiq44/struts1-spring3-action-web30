package org.sid.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.sid.entities.Produit;
import org.sid.form.ProduitForm;
import org.sid.service.ICatalogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProduitSaveAction extends Action {

	private static final Logger LOG = LoggerFactory.getLogger(ProduitSaveAction.class);

	@Autowired
	private ICatalogueService service;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("execute()");

		ProduitForm produitForm = (ProduitForm) form;
		Produit produit = new Produit();
		BeanUtils.copyProperties(produitForm, produit);

		ActionErrors actionErrors = form.validate(mapping, request);
		if (null != actionErrors && !actionErrors.isEmpty()) {
			saveErrors(request, actionErrors);

			request.setAttribute("editMode", false);
			request.setAttribute("produit", produit);
			request.setAttribute("produits", service.listProduits());

			return mapping.getInputForward();
		}

		if (null == produit.getReference()) {
			LOG.debug("add");
			service.addProduit(produit);
		} else {
			LOG.debug("update");
			service.updateProduit(produit);
		}

		request.setAttribute("editMode", false);
		request.setAttribute("produit", new Produit());
		request.setAttribute("produits", service.listProduits());

		return mapping.findForward("success");
	}
}
