<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<logic:present name="adm" >
 
 <% 
 //coloca atributos na sessão para serem passados nos links
 String atendLink = "atendente";
 
 session.setAttribute("atendLink", atendLink);
 
 String medLink = "medico";
 
 session.setAttribute("medLink", medLink);
 
 
 %>
 
 <html:link action="Cadastrar" paramId="func" paramName="atendLink"  > <bean:message bundle="i18n"  key="cadastro.atendente" />  </html:link> 
 <br/> 
 <html:link action="ListarFunc" paramId="func" paramName="atendLink"  > <bean:message bundle="i18n"  key="lista.atendente" />  </html:link>  
 
 <br/>
 <html:link action="Cadastrar" paramId="func" paramName="medLink"  > <bean:message bundle="i18n"  key="cadastro.medico" />  </html:link>  
 <br/>
 <html:link action="ListarFunc" paramId="func" paramName="medLink"  > <bean:message bundle="i18n"  key="lista.medico" />  </html:link>  


 </logic:present>


<logic:present  name="atendente" ></logic:present>

<logic:present  name="medico"   ></logic:present>

</body>
</html>