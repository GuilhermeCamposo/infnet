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
		</h:form>
	
		<h:outputText rendered="#{!atendimentoPacienteBean.haConsultas}"
			value="não há consultas para você" />


		<h:form id="cadastro" rendered="#{atendimentoPacienteBean.haConsultas}" >


			<h:outputText value="#{msgs.pacient}" /> : <h:outputText
				value="#{atendimentoPacienteBean.consulta.paciente.nome}" />

			<br />

			<h:outputText value="#{msgs.attendant}" /> : <h:outputText
				value="#{atendimentoPacienteBean.consulta.atendente.nome}" />

			<br />

			<h:outputText value="#{msgs.prescription}" />
			<br />
			<h:inputTextarea
				value="#{atendimentoPacienteBean.consulta.prescricao}" cols="15"
				rows="6" />

			<br />
			<h:commandButton value="#{msgs.save}"
				action="#{atendimentoPacienteBean.salvarConsulta}" />



		</h:form>

		<h:messages />
	</body>
</f:view>
</html>