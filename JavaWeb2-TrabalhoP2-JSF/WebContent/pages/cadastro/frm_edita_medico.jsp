<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Médicos</title>
	</head>
	<body>
		<h:form>

			<f:subview id="header">
				<jsp:include page="/pages/template/inc_header.jsp" />
			</f:subview>

			<h:dataTable var="medico" value="#{exibirMedicosBean.lstMedicos}"
				border="1" binding="#{exibirMedicosBean.tabela}">

				<h:column>
					<f:facet name="header">
						<h:outputText value="Matricula" />
					</f:facet>
					<h:outputText value="#{medico.matricula}"></h:outputText>

				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs.name}" />
					</f:facet>
					<h:outputText value="#{medico.nome}"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs.cpf}" />
					</f:facet>
					<h:outputText value="#{medico.cpf}"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs.specialty}" />
					</f:facet>
					<h:outputText value="#{medico.especialidade}"></h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Ação" />
					</f:facet>
					<h:commandButton action="#{exibirMedicosBean.excluir}"
						value="Excluir" />
						
							<h:commandButton action="#{exibirMedicosBean.editar}"
						value="Editar" />
	
				</h:column>

			</h:dataTable>
		</h:form>
	</body>
</f:view>
</html>