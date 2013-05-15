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
<title><h:outputText value="#{msgs.register_doctor}" /></title>
	</head>
	<body>

		<h:form>
			<f:subview id="header">
				<jsp:include page="/pages/template/inc_header.jsp" />
			</f:subview>
			
			<h:inputHidden value="#{cadastroFuncionarioBean.matricula}" />

			<label for="nome"> <h:outputText value="#{msgs.name}"   />
			</label>
			<h:inputText id="nome" value="#{cadastroFuncionarioBean.nome}"  />

			<br />

			<label for="CPF"> <h:outputText value="#{msgs.cpf}" />
			</label>
			<h:inputText id="CPF" value="#{cadastroFuncionarioBean.cpf}" />

			<br />

			<label for="login"> <h:outputText value="#{msgs.usarname}" />
			</label>
			<h:inputText id="login" value="#{cadastroFuncionarioBean.login}" />

			<br />

			<label for="senha"> <h:outputText value="#{msgs.password}" />
			</label>
			<h:inputText id="senha" value="#{cadastroFuncionarioBean.senha}" />

			<br />

			<label for="especialidade"> <h:outputText
					value="#{msgs.specialty}" />
			</label>
			<h:inputText id="especialidade"
				value="#{cadastroFuncionarioBean.especialidade}" />

			<br />

			<h:commandButton action="#{cadastroFuncionarioBean.cadastrarMedico}"
				value="#{msgs.register}" />

		</h:form>

		<h:messages />
	</body>

</f:view>
</html>