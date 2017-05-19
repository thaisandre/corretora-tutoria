<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<p>Login</p>
		<br />
		<form action="mvc?logica=Login" method="post">
			login: <input type="text" name="login" />
			<br />
			senha: <input type="password" name="senha" />
			<br />
			<input type="submit" value="entrar" />
		</form>	
		<span style="color:red">${mensagem}</span>
		<br />
		<form action="mvc?logica=FormularioUsuario" method="post">
			<input type="submit" value="cadastrar" />
		</form>
</body>
</html>