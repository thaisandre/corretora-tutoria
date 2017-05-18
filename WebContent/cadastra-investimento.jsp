<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cadastro investimento</title>
</head>
<body>
	<c:import url="/WEB-INF/paginas/cabecalho.jsp" />
	
	<p>Cadastro Investimento:</p>
	<br />
	
	<form action="mvc?logica=AdicionaInvestimento" method="post">
		tipo: <select name="tipo">
			<option type="text" name="CDB" value="CDB">CDB</option>
			<option type="text" name="LCI" value="LCI">LCI</option>
			<option type="text" name="FDI" value="FDI">FDI</option>
		</select><span style="cloro:red" >${erros.get("tipo")}</span>
		<br />
		
		taxa: <input type="text" name="taxaDeJuros" /><span style="color:red" >${erros.get("taxaDeJuros")}</span>
		<br />
		
		prazo: <input type="text" name="prazo" /><span style="cloro:red" >${erros.get("prazo")}</span>
		<br />
		
		valor mínimo: <input type="text" name="valorMinimo" /><span style="cloro:red" >${erros.get("valorMinimo")}</span>
		<br />
		
		<input type="submit" value="cadastrar" />
	</form>
</body>
</html>