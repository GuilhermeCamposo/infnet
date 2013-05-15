<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		//coloca atributos na sessão para serem passados nos links
		Boolean resposta = (Boolean) request.getAttribute("valido");

		if (resposta != null && resposta) {
	%>
	CPF válido
	<%
		} else if (resposta != null && !resposta) {
	%>
	CPF inválido
	<%
		}
	%>

	<form action="ValidacaoServlet" method="post">
		<h1>Validação</h1>
		CPF: <input type='text' id="cpf" name="cpf"> <input
			type='submit' value='submeter'>
	</form>

</body>
</html>