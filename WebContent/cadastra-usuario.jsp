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
		<span style="color:red" ><c:out value="${errorMessage}" /></span>
		<br />
		<form action="mvc?logica=AdicionaUsuario" method="post">
			nome: <input type="text" name="nome" /><br /><br />
			login: <input type="text" name="login" /><br /><br />
			senha: <input type="text" name="senha" /><br />
			<br />
			<input type="submit" value="cadastrar" />
		</form>	
	</body>
</html>