<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><h:outputText value="#{msgs.title_register_paciente}" />
</title>
	</head>
	<body>

		<h:form>
			<f:subview id="header">
				<jsp:include page="/pages/template/inc_header.jsp" />
			</f:subview>
			
			<label for="nome"> <h:outputText value="#{msgs.name}" />
			</label>
			<h:inputText id="nome" value="#{cadastroPacienteBean.nome}" />

			<br />

			<label for="CPF"> <h:outputText value="#{msgs.cpf}" />
			</label>
			<h:inputText id="CPF" value="#{cadastroPacienteBean.cpf}" />

			<br />

			<label for="telefone"> <h:outputText
					value="#{msgs.telephone}" />
			</label>
			<h:inputText id="telefone" value="#{cadastroPacienteBean.telefone}" />

			<h:commandButton action="#{cadastroPacienteBean.cadastrarPaciente}"
				value="#{msgs.register}" />


		</h:form>

		<h:messages />

	</body>
</f:view>

</html>