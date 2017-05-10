<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro Investimento</title>
</head>
<body>
	<form action="mvc?logica=AdicionaInvestimentoLogica" method="post">
		<select name="tipo">
			<option type="text" name="CDB" value="CDB">CDB</option>
			<option type="text" name="LCI" value="LCI">LCI</option>
			<option type="text" name="FDI" value="FDI">FDI</option>
		</select><br /> 
		taxa: <input type="text" name="taxaDeJuros" /><br />
		prazo: <input type="text" name="prazo" /><br /> 
		valor mínimo: <input type="text" name="valorMinimo" /><br /> 
		<input type="submit" value="cadastrar" />
	</form>
</body>
</html>