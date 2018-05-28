<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><bean:message key="index.title" /></title>
</head>
<body>
	<logic:redirect href="produits/index.do" />
</body>
</html>
