package org.sid.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.sid.entities.Produit;
import org.sid.service.ICatalogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProduitDeleteAction extends Action {

	private static final Logger LOG = LoggerFactory.getLogger(ProduitDeleteAction.class);

	@Autowired
	private ICatalogueService service;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("execute()");

		String ref = request.getParameter("ref");
		service.deleteProduit(ref);

		request.setAttribute("editMode", false);
		request.setAttribute("produit", new Produit());
		request.setAttribute("produits", service.listProduits());

		return mapping.findForward("success");
	}
}
