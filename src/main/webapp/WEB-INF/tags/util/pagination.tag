<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ attribute name="thispage" type="org.sid.page.PageImpl" required="true" rtexprvalue="true" description="The current Page"%>
<%@ attribute name="action" type="java.lang.String" required="true" rtexprvalue="true" description="The current Action"%>

<bean:define id="totalPages" name="thispage" property="totalPages" />
<bean:define id="offset" name="thispage" property="offset" />
<bean:define id="totalElements" name="thispage" property="totalElements" />
<bean:define id="size" name="thispage" property="size" />

<table>
	<tr><td>
		${totalElements} items found, displaying ${offset + 1} to ${offset + size}.
		<br />
		<logic:iterate name="thispage" property="pagesNo" id="varpage">
			<bean:define id="number" name="thispage" property="number" />

			<logic:equal name="varpage" value="${number}">
				<bean:write name="varpage" />
			</logic:equal>

			<logic:notEqual name="varpage" value="${number}">
				<html:link action="${action}" paramName="varpage" paramId="page">
					<bean:write name="varpage" />
				</html:link>
			</logic:notEqual>

			<logic:notEqual name="varpage" value="${totalPages}">
				,
			</logic:notEqual>
		</logic:iterate>
	</td></tr>
</table>
