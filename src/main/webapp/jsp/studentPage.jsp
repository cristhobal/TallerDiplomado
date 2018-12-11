<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de código</title>
</head>
<body>
	<form:form id="regTxtForm" modelAttribute="texto" action="registerTextProcess" method="post">
		<table align="center">
			<tr>
				<td><form:label path="username">Profesor</form:label></td>
				<td><form:input path="username" name="username" id="username" value="${username}"/>
				</td>
			</tr>
			<tr>
				<td>Ingrese el código</td>
				<td><form:textarea path="texto" name="texto" id="texto" /> 
				</td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="registertext" name="registertext">Register code</form:button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>