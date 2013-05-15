package p1.controle.forms.logon;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LogarForm extends ActionForm {

	private static final long serialVersionUID = -906699897155427290L;

	private String senha, login;

	private int matricula;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha.trim();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login.trim();
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (senha.equals("") && login.equals("")) {

			errors.add("login", new ActionMessage("erro.logon.login"));
			errors.add("senha", new ActionMessage("erro.logon.senha"));

			return errors;

		} else if (login.equals("")) {

			errors.add("login", new ActionMessage("erro.logon.login"));

		} else if (senha.equals("")) {

			errors.add("senha", new ActionMessage("erro.logon.senha"));

		}

		return errors;
	}

}
