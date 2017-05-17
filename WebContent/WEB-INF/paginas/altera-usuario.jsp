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
	<c:import url="cabecalho.jsp" />
	<p>Editar Usuário</p><br />
		<form action="mvc?logica=AlteraUsuario&id=${usuario.id}" method="post">
			nome: <input type="text" name="nome" value="${usuario.nome}"/><br /><br />
			login: <input type="text" name="login" value="${usuario.login}"/><br /><br />
			senha: <input type="text" name="senha" value="${usuario.senha}"/><br /><br />
			<input type="submit" value="editar" />
</body>
</html>