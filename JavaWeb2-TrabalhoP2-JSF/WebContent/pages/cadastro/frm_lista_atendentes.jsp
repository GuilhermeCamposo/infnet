<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	</head>
	<body>
		<h:form>

			<f:subview id="header">
				<jsp:include page="/pages/template/inc_header.jsp" />
			</f:subview>

			<h:dataTable var="atendente"
				value="#{exibirAtendentesBean.lstAtendentes}" border="1"
				binding="#{exibirAtendentesBean.tabela}">

				<h:column>
					<f:facet name="header">
						<h:outputText value="Id" />
					</f:facet>
					<h:outputText value="#{atendente.matricula}"></h:outputText>

				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs.name}" />
					</f:facet>
					<h:outputText value="#{atendente.nome}"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs.cpf}" />
					</f:facet>
					<h:outputText value="#{atendente.cpf}"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs.turn}" />
					</f:facet>
					<h:outputText value="#{atendente.turno}"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Ação" />
					</f:facet>
					<h:commandButton action="#{exibirAtendentesBean.excluir}"
						value="Excluir" />
						<br/>
						
					<h:commandButton action="#{exibirAtendentesBean.editar}"
						value="Editar"/>

				</h:column>

			</h:dataTable>
		</h:form>
	</body>
</f:view>
</html>