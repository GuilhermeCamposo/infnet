<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto - Detalhe</title>
</head>
<body>
<f:view>
<h:form>

<h:outputText value="Nome :" /><h:outputText value="#{ExibeProdutos.prodSelecionado.nome}" />
<br/>

<h:outputText value="Modelo :" /><h:outputText value="#{ExibeProdutos.prodSelecionado.modelo}" />
<br/>

<h:outputText value="Preço :" /><h:outputText value="#{ExibeProdutos.prodSelecionado.preco}" />

<br/>
<h:commandLink value="voltar" action="busca" />
</h:form>

</f:view>
</body>
</html>