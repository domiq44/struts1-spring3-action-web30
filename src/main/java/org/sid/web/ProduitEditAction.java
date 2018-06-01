package org.sid.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.sid.form.ProduitForm;
import org.sid.service.ICatalogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProduitEditAction extends Action {

	private static final Logger LOG = LoggerFactory.getLogger(ProduitEditAction.class);

	@Autowired
	private ICatalogueService service;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("execute()");

		String ref = request.getParameter("ref");

		ProduitForm produitForm = (ProduitForm) form;

		produitForm.setEditMode(true);
		produitForm.setProduit(service.getProduit(ref));
		produitForm.setProduits(service.listProduits());

		return mapping.findForward("success");
	}
}
