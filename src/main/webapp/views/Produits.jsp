<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>
<!DOCTYPE html>
<html:html>
<head>
<meta charset="UTF-8" />
<title><bean:message key="produits.title" /></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<bean:define id="number" name="produitForm" property="pages.number" />
	<div>
		<html:form action="/produits/save" method="post">
			<table>
				<tr>
					<td><bean:message key="reference.label" /></td>
					<td>
						<logic:equal name="produitForm" property="editMode" value="false">
							<html:text property="produit.reference" />
						</logic:equal>
						<logic:equal name="produitForm" property="editMode" value="true">
							<html:hidden property="produit.reference" />
							<bean:write name="produitForm" property="produit.reference" />
						</logic:equal>
					</td>
					<td><html:errors property="reference" /></td>
				</tr>
				<tr>
					<td><bean:message key="designation.label" /></td>
					<td><html:text property="produit.designation" /></td>
					<td><html:errors property="designation" /></td>
				</tr>
				<tr>
					<td><bean:message key="prix.label" /></td>
					<td><html:text property="produit.prix" /></td>
					<td><html:errors property="prix" /></td>
				</tr>
				<tr>
					<td><bean:message key="quantite.label" /></td>
					<td><html:text  property="produit.quantite" /></td>
					<td><html:errors property="quantite" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<html:checkbox property="produit.promo">
							<bean:message key="promo.label" />
						</html:checkbox>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<div>
							<html:hidden property="page" value="${number}" />
							<html:submit value="Save" />
						</div>
					</td>
				</tr>
			</table>
		</html:form>
	</div>
	<div>
		<bean:define id="pages" name="produitForm" property="pages" />
		<util:pagination thispage="${pages}" action="/produits/index" />
		<table class="table1">
			<tr>
				<th><bean:message key="reference.th" /></th>
				<th><bean:message key="designation.th" /></th>
				<th><bean:message key="prix.th" /></th>
				<th><bean:message key="quantite.th" /></th>
				<th><bean:message key="promo.th" /></th>
			</tr>
			<logic:iterate name="produitForm" property="pages.content" id="p">
				<tr>
					<td><bean:write name="p" property="reference" /></td>
					<td><bean:write name="p" property="designation" /></td>
					<td><bean:write name="p" property="prix" /></td>
					<td><bean:write name="p" property="quantite" /></td>
					<td><bean:write name="p" property="promo" /></td>
					<td>
						<html:form action="produits/delete" method="post">
							<html:hidden property="ref" value="${p.reference}" />
							<bean:define id="myMsg">
								<bean:message key="confirm.delete" arg0="${p.reference}" />
							</bean:define>
							<html:submit value="Delete" onclick="javascript:return confirm('${myMsg}')" />
						</html:form>
					</td>
					<td>
						<html:form action="produits/edit" method="post">
							<html:hidden property="ref" value="${p.reference}" />
							<html:hidden property="page" value="${number}" />
							<html:submit value="Edit" />
						</html:form>
					</td>
				</tr>
			</logic:iterate>
		</table>
	</div>
</body>
</html:html>
