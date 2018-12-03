<%@page import="cl.udechile.diplomado.tallerdeproyectos.model.User"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de código</title>
</head>
<body>
	<form:form id="regTxtForm" modelAttribute="login" action="ShowText" method="post">
		<table align="center">
			<tr>
				<td><form:label path="username">Profesors</form:label></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><form:radiobuttons items="${profesors}" itemLabel="username" path="username" itemValue="username" id="username" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="ShowText" name="ShowText">View code</form:button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>