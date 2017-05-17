<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<p>Usuarios:</p>
<table>
	<tr>
		<th>nome</th>
		<th>login</th>
		<th>senha</th>
	</tr>
	<c:forEach var="usuario" items="${usuarios}">
		<tr>
			<td>${usuario.nome}</td>
			<td>${usuario.login}</td>
			<td>${usuario.senha}</td>
			<td><a href="mvc?logica=RemoveUsuario&id=${usuario.id}">Remover</a></td>
			<td><a href="mvc?logica=MostraUsuario&id=${usuario.id}">Editar</a></td>
		</tr>
	</c:forEach>		
	</table>
		
</body>
</html>