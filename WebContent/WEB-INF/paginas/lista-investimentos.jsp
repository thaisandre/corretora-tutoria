<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>tipo</td>
		<td>taxa (a.a)</td>
		<td>prazo (meses)</td>
		<td>valor mínimo</td>
	</tr>
	<c:forEach var="investimento" items="${investimentos}">
		<tr>
			<td>${investimento.tipo}</td>
			<td>${investimento.taxaDeJuros}</td>
			<td>${investimento.prazo}</td>
			<td>${investimento.valorMinimo}</td>
		</tr>
	</c:forEach>		
	</table>
</body>
</html>