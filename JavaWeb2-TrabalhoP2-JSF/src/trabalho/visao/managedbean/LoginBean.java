package trabalho.visao.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import trabalho.modelo.dao.FuncionarioDao;
import trabalho.modelo.dao.MedicoDao;
import trabalho.modelo.entidades.Funcionario;
import trabalho.modelo.entidades.Medico;

public class LoginBean {

	private String username;

	private String password;

	private String nomeFunc; // nome do funcionário

	private String welcomeImage;

	/**
	 * valida se a senha e o usuário estão corretos e encaminha para página
	 * principal
	 * 
	 * @return caminho
	 */
	public String logOnAction() {

		FuncionarioDao dao = FuncionarioDao.getInstance();

		Funcionario func = dao.buscarFuncionario(password, username);

		if (func != null) {

			nomeFunc = func.getNome();

			if (func.getFuncao().trim().equals("medico")) {
				Medico medico = MedicoDao.getInstance().buscarMedico(
						func.getMatricula());

				((HttpServletRequest) FacesContext.getCurrentInstance()
						.getExternalContext().getRequest()).getSession()
						.setAttribute("user", medico);
			}
			return "principal";
		}

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"usuário não encontrado", null));

		return "login";
	}

	public String logOut() {

		return null;
	}

	public String getNomeFunc() {
		return nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWelcomeImage() {
		return welcomeImage;
	}

	public void setWelcomeImage(String welcomeImage) {
		this.welcomeImage = welcomeImage;
	}

}
