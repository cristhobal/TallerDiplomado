<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de código</title>
</head>
<body>
	<form:form id="regTxtForm" modelAttribute="texto" action="conectionPython" method="post">
		<table align="center">
			<tr>
				<td><form:label path="texto">Code</form:label></td>
				<td> <form:textarea path="texto"  id="texto" rows="10" value="${texto.texto}" />
				<form:hidden path="username" name="username" id="username" value="${texto.username}"/>
				</td>
			</tr>
			<tr>
				<td>Enter your answer</td>
				<td><form:input path="texto2" name="texto2" id="texto2" value=""/> 
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