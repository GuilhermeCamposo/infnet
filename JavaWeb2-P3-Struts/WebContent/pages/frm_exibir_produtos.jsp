<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
</head>
<body>

	<table border="2">
		<tr>
			<th colspan="3">Boa Dica</th>
		</tr>
		<tr>
			<th>Produto</th>
			<th>Modelo</th>
			<th>Preço</th>
		</tr>
		<logic:iterate id="produto" name="produtos">
			<tr>
				<td><h:link page="/DetalharProduto.do" paramId="id"
						paramName="produto" paramProperty="id">

						<bean:write name="produto" property="nome" />

					</h:link></td>

				<td><bean:write name="produto" property="modelo" /></td>

				<td><bean:write name="produto" property="preco" format="0.00" /></td>
			</tr>
		</logic:iterate>
	</table>
	<br />
	<h:form action="/BuscaProdutos.do">
		<h:text property="busca" />
		<h:submit value="buscar" />
	</h:form>


</body>
</html>