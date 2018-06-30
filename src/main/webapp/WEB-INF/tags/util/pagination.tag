<%@tag import="java.util.Arrays"%>
<%@tag import="java.util.Set"%>
<%@tag import="java.util.TreeSet"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ attribute name="thispage" type="org.sid.page.PageImpl" required="true" rtexprvalue="true" description="The current Page"%>
<%@ attribute name="action" type="java.lang.String" required="true" rtexprvalue="true" description="The current Action"%>

<style>
ul.pagination {
	display: inline-block;
	padding: 0;
	margin: 0;
}

ul.pagination li {
	display: inline;
}

ul.pagination li a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	border: 1px solid black;
}

.pagination li:first-child a {
	border-top-left-radius: 20px;
	border-bottom-left-radius: 20px;
}

.pagination li:last-child a {
	border-top-right-radius: 20px;
	border-bottom-right-radius: 20px;
}

ul.pagination li a.active {
	background-color: white;
	color: blue;
	border: 1px solid gray;
}

ul.pagination li a.notActive {
	/* nothing special */
	cursor: default;
}

ul.pagination li a.text {
	background-color: white;
	border: 1px solid white;
	cursor: default;
}

div.center {
	text-align: center;
}
</style>

<bean:define id="totalPages" name="thispage" property="totalPages" />
<bean:define id="offset" name="thispage" property="offset" />
<bean:define id="totalElements" name="thispage" property="totalElements" />
<bean:define id="size" name="thispage" property="size" />

<div class="center">
	<ul class="pagination">
			<li>
				<bean:define id="number" name="thispage" property="number" />
				<logic:notEqual name="number" value="1">
					<html:link action="${action}" styleClass="${number == '1' ? 'notActive' : 'active'}">
						First
						<html:param name="page" value="1" />
						<html:param name="size" value="${size}" />
					</html:link>
					<html:link action="${action}" styleClass="${number == '1' ? 'notActive' : 'active'}">
						Previous
						<html:param name="page" value="${number - 1}" />
						<html:param name="size" value="${size}" />
					</html:link>
				</logic:notEqual>
				<logic:equal name="number" value="1">
					<html:link href="#" styleClass="notActive">
						First
					</html:link>
					<html:link href="#" styleClass="notActive">
						Previous
					</html:link>
				</logic:equal>
				<html:link href="#" styleClass="text">
					displaying ${offset + 1} to ${offset + size}
				</html:link>
				<logic:notEqual name="number" value="${totalPages}">
					<html:link action="${action}" styleClass="${number == totalPages ? 'notActive' : 'active'}">
						Next
						<html:param name="page" value="${number + 1}" />
						<html:param name="size" value="${size}" />
					</html:link>
					<html:link action="${action}" styleClass="${number == totalPages ? 'notActive' : 'active'}">
						Last
						<html:param name="page" value="${totalPages}" />
						<html:param name="size" value="${size}" />
					</html:link>
				</logic:notEqual>
				<logic:equal name="number" value="${totalPages}">
					<html:link href="#" styleClass="notActive">
						Next
					</html:link>
					<html:link href="#" styleClass="notActive">
						Last
					</html:link>
				</logic:equal>
			</li>
	</ul>
</div>
<div>
	Found ${totalElements} records.
	Records per page
	<logic:iterate id="current_size" collection="<%=new TreeSet<Integer>(Arrays.asList(5, 10, 15, 20, 25))%>">
		<logic:equal name="current_size" value="${size}">
			${current_size}
		</logic:equal>
		<logic:notEqual name="current_size" value="${size}">
			<html:link action="${action}">
				${current_size}
				<html:param name="page" value="1" />
				<html:param name="size" value="${current_size}" />
			</html:link>
		</logic:notEqual>
	</logic:iterate>
</div>
