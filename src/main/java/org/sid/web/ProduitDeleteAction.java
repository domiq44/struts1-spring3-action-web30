package org.sid.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.sid.entities.Produit;
import org.sid.form.ProduitForm;
import org.sid.service.ICatalogueService;
import org.sid.tools.NumberUtils;
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
		int page = NumberUtils.toInt(request.getParameter("page"), 1);
		int size = NumberUtils.toInt(request.getParameter("size"), 5);

		service.deleteProduit(ref);

		ProduitForm produitForm = (ProduitForm) form;

		produitForm.setEditMode(false);
		produitForm.setProduit(new Produit());
		produitForm.setPages(service.newPageRequest(page, size));

		return mapping.findForward("success");
	}
}
