<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>


<html:form action="Cadastrar" >

<label  for="nome" ></label>
<html:text property="nome"></html:text>
<br/>

<label for="cpf"> </label>
<html:text property="cpf" ></html:text>
<br/>

<label for="login"></label>
<html:text property="login"></html:text>
<br/>

<label for="senha" ></label>
<html:text property="senha"></html:text>

<logic:present name="medico" > 

<label for="especialidade" ></label>
<html:optionsCollection/>

</logic:present>


<logic:present name="atendente" > 

<label for="turno" ></label>
<html:optionsCollection/>

</logic:present>


</html:form>

<br/>
<html:messages id="msg" message="true">
<bean:write name="msg"/><br>
</html:messages>

</body>
</html>