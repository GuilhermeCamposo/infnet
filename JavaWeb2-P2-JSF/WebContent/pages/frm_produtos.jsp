<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
</head>
<body>
	<f:view>

		<h:form>
			<h:dataTable var="produto" value="#{ExibeProdutos.produtos}"
				border="1" binding="#{ExibeProdutos.tabela}">
				
				<f:facet name="header">
						<h:outputText value="Boa Dica" />
				</f:facet>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Produto" />
					</f:facet>
				<h:commandLink action="#{ExibeProdutos.detalharProduto}" > 	<h:outputText value="#{produto.nome}"></h:outputText> </h:commandLink>

				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Modelo" />
					</f:facet>
					<h:outputText value="#{produto.modelo}"></h:outputText>

				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Preço" />
					</f:facet>
					<h:outputText value="#{produto.preco}"></h:outputText>

				</h:column>

			</h:dataTable>
<br/>
			<h:inputText value="#{ExibeProdutos.busca}" />
			<h:commandButton action="#{ExibeProdutos.buscarProdutos }"
				value="busca" />

		</h:form>

	</f:view>

</body>
</html>