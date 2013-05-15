<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhe-Produto</title>
</head>
<body>

<logic:present name="produto" >

Produto : <bean:write name="produto"  property="nome" />
<br/>

Modelo : <bean:write name="produto" property="modelo" />
<br/>

Preço : <bean:write name="produto" property="preco" format="0.00" />

</logic:present>
<br/>
<h:link forward="produtos" > voltar </h:link>



</body>
</html>