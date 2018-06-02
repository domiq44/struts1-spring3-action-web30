<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ attribute name="thispage" type="org.sid.page.PageImpl" required="true" rtexprvalue="true" description="The current Page"%>
<%@ attribute name="action" type="java.lang.String" required="true" rtexprvalue="true" description="The current Action"%>

<bean:define id="totalPages" name="thispage" property="totalPages" />
<bean:define id="offset" name="thispage" property="offset" />
<bean:define id="totalElements" name="thispage" property="totalElements" />
<bean:define id="size" name="thispage" property="size" />

<div>
	<p></p>
	<ul class="pagination">
		<li>${totalElements} items found, displaying ${offset + 1} to ${offset + size}.</li>
	</ul>
	<p></p>
	<ul class="pagination">
		<logic:iterate name="thispage" property="pagesNo" id="varpage">
			<li>
				<bean:define id="number" name="thispage" property="number" />
				<logic:equal name="varpage" value="${number}">
					<html:link action="${action}" paramName="varpage" paramId="page" styleClass="active">
						<bean:write name="varpage" />
					</html:link>
				</logic:equal>
				<logic:notEqual name="varpage" value="${number}">
					<html:link action="${action}" paramName="varpage" paramId="page" styleClass="notActive">
						<bean:write name="varpage" />
					</html:link>
				</logic:notEqual>
			</li>
		</logic:iterate>
	</ul>
</div>
