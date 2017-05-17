<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editar investimento</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<p>Editar Investimento:</p><br />
	<form action="mvc?logica=AlteraInvestimento&id=${investimento.id}" method="post">
		<select name="tipo">
			<option type="text" name="CDB" value="CDB" ${investimento.tipo == 'CDB' ? 'Selected' : ""} >CDB</option>
			<option type="text" name="LCI" value="LCI" ${investimento.tipo == 'LCI' ? 'Selected' : ""} >LCI</option>
			<option type="text" name="FDI" value="FDI" ${investimento.tipo == 'FDI' ? 'Selected' : ""} >FDI</option>
		</select><br /> <br />
		taxa: <input type="text" name="taxaDeJuros" value="${investimento.taxaDeJuros}"/><br /><br />
		prazo: <input type="text" name="prazo" value="${investimento.prazo}"/><br /> <br />
		valor mínimo: <input type="text" name="valorMinimo" value="${investimento.valorMinimo }"/><br /><br /> 
		<input type="submit" value="editar" />
	</form>

</body>
</html>