<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cadastro usuario</title>
	</head>
	<body>
	
		<c:import url="/WEB-INF/paginas/cabecalho.jsp" />
		
		<p>Cadastro Usuário:</p>
		<br />
		<form action="mvc?logica=AdicionaUsuario" method="post">
			nome: <input type="text" name="nome" /><span style="color:red" >${erros.get("nome")}</span>
			<br />
			login: <input type="text" name="login" /><span style="color:red" >${erros.get("login")}</span>
			<br />
			senha: <input type="password" name="senha" /><span style="color:red" >${erros.get("senha")}</span>
			<br />
			<input type="submit" value="cadastrar" />
		</form>	
	</body>
</html>