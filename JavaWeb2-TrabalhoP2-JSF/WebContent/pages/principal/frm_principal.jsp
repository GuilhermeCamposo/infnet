<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>  <h:outputText value="#{msgs.welcome}" />  </title>
</head>
<body>

<h:form>
<f:subview id="header">
	<jsp:include page="/pages/template/inc_header.jsp" />
</f:subview>


<!--   parte do adm -->

<h:commandLink action="cadastroAtendente" value="#{msgs.register_atendent}"/>
<br/>

<h:commandLink action="cadastroMedico" value="#{msgs.register_doctor}" />
<br/>

<h:commandLink action="exibirMedicos" value="#{msgs.list_doctor}" />

<!--  fim parte do adm -->

<!-- parte do atendente  -->
<br/>
<h:commandLink action="agendarConsulta" value="#{msgs.register_consultation}" />
<br/>
<h:commandLink action="cadastroPaciente" value="#{msgs.register_pacient}" />

<br/>
<h:commandLink action="exibirAtendentes"  value="Listar Atendentes"  />


<!-- fim parte do atendente -->

<!-- parte do médico -->
<br/>
<h:commandLink action="atenderPaciente" value="Atender Paciente" />

<!-- fim parte do médico médico -->

</h:form>

</body>
</f:view>

</html>