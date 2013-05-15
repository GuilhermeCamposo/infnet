package trabalho.visao.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import trabalho.modelo.dao.AtendenteDao;
import trabalho.modelo.dao.MedicoDao;
import trabalho.modelo.entidades.Atendente;
import trabalho.modelo.entidades.Funcionario;
import trabalho.modelo.entidades.Medico;
import trabalho.modelo.util.TurnosAtendente;
import trabalho.visao.util.Mensagens;

public class CadastroFuncionarioBean extends Funcionario {

	private static final long serialVersionUID = -8838453474365559813L;

	public Medico medico;
	public Atendente atendente;

	public CadastroFuncionarioBean() {

		carregaTurnos();

		HttpSession session = (HttpSession) ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();

		medico = (Medico) session.getAttribute("medico");
		session.setAttribute("medico", null);

		atendente = (Atendente) session.getAttribute("atendente");
		session.setAttribute("atendente", null);

		if (medico != null) {

			setCpf(medico.getCpf());
			setLogin(medico.getLogin());
			setNome(medico.getNome());
			setSenha(medico.getSenha());
			setMatricula(medico.getMatricula());
			setEspecialidade(medico.getEspecialidade());

		}

		if (atendente != null) {

			setCpf(atendente.getCpf());
			setLogin(atendente.getLogin());
			setNome(atendente.getNome());
			setSenha(atendente.getSenha());
			setMatricula(atendente.getMatricula());

		}

	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	private String especialidade;

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	// ====================================================

	private Integer turno = 0;

	private SelectItem[] turnos;

	private void carregaTurnos() {

		turnos = new SelectItem[TurnosAtendente.values().length];
		int i = 0;
		for (TurnosAtendente string : TurnosAtendente.values()) {
			turnos[i] = new SelectItem(i, string.getValor());
			i++;
		}

	}

	public SelectItem[] getTurnos() {
		return turnos;
	}

	public void setTurnos(SelectItem[] turnos) {
		this.turnos = turnos;
	}

	// =====================================================
	/**
	 * insere valores na entidade do médico chamando o DAO pra salvar a
	 * instancia ou fazer update
	 * 
	 * @return
	 */
	public String cadastrarMedico() {

		medico = new Medico();

		medico.setCpf(getCpf());
		medico.setLogin(getLogin());
		medico.setNome(getNome());
		medico.setSenha(getSenha());
		medico.setEspecialidade(especialidade);
		medico.setFuncao("medico");
		medico.setMatricula(getMatricula());

		MedicoDao.getInstance().cadastrarMedico(medico);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagens.getText(
						"msgs", "register.sucess"), null));

		return null;

	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public String cadastrarAtendente() {

		atendente = new Atendente();

		atendente.setCpf(getCpf());
		atendente.setLogin(getLogin());
		atendente.setNome(getNome());
		atendente.setSenha(getSenha());
		atendente.setFuncao("atendente");
		atendente.setMatricula(getMatricula());

		atendente.setTurno(TurnosAtendente.values()[turno].getValor());

		AtendenteDao.getInstance().cadastrarAtendente(atendente);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagens.getText(
						"msgs", "register.sucess"), null));

		return null;
	}

}
