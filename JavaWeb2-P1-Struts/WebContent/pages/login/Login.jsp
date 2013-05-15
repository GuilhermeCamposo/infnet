<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="Login" bundle="i18n" /></title>
</head>
<body>

	<div align="center">

		<h3>
			<bean:message key="Login" bundle="i18n" />
		</h3>

		<hr />

		<html:form action="/Logar">
			<label for="login"> <bean:message key="Login" bundle="i18n" />
				:
			</label>
			<html:text property="login" />

			<br />

			<label for="senha"> <bean:message key="Senha" bundle="i18n" />
				:
			</label>

			<html:password property="senha" />
			<br />

			<html:submit>
				<bean:message key="Login" bundle="i18n" />
			</html:submit>

		</html:form>
		<html:errors />
	</div>

</body>
</html>