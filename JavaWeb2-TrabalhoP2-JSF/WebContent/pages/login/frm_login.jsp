<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="/JavaWeb2-TrabalhoP2/pages/estilo.css" >
<title> <h:outputText value="#{msgs.login}" ></h:outputText> </title>
</head>
<body>

<div align="center" >

<h:graphicImage value="#{LoginBean.welcomeImage}"/>
<br/>
<br/>

<h:form>

<label for="username"  > <h:outputText  value="#{msgs.usarname}" />  </label>
<h:inputText id="username" value="#{LoginBean.username}" />

<br/>
<br/>

<label for="password"  > <h:outputText  value="#{msgs.password}" />  </label>
<h:inputSecret  id="password" value="#{LoginBean.password}" />

<br/>
<br/>
<h:commandButton  action="#{LoginBean.logOnAction}" value="#{msgs.logon}" ></h:commandButton>

<h:messages errorStyle="Erros" />

</h:form>
</div>




</body>
</f:view>
</html>