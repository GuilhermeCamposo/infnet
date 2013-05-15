<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<html>
<h:commandLink action="paginaPrincipal" value="#{msgs.home}"  /> 
<div align="right" >   <h:outputText value="#{msgs.welcome}" /> ,  <h:outputText value="#{LoginBean.nomeFunc}" />   </div>
</html>
