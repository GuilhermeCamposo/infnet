package trabalho.visao.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import trabalho.modelo.dao.ConsultaDao;
import trabalho.modelo.entidades.Consulta;
import trabalho.modelo.entidades.Medico;
import trabalho.visao.util.Mensagens;

public class AtendimentoPacienteBean {

	private Consulta consulta;

	private boolean haConsultas = true;

	public AtendimentoPacienteBean() {

		FacesContext context = FacesContext.getCurrentInstance();
		Medico medico = null;

		try {
			medico = (Medico) ((HttpServletRequest) context
					.getExternalContext().getRequest()).getSession().getAttribute("user");

			consulta = ConsultaDao.getInstance().buscarConsultaPorMedico(medico);

			if (consulta == null) {

				haConsultas = false ;
			}

		} catch (Exception e) {
            
			haConsultas = false ;
			e.printStackTrace();
		}

	}

	public String salvarConsulta() {

		ConsultaDao.getInstance().finalizarConsulta(consulta);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagens.getText(
						"msgs", "register.sucess"), null));

		return null;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public boolean isHaConsultas() {
		return haConsultas;
	}

	public void setHaConsultas(boolean haConsultas) {
		this.haConsultas = haConsultas;
	}

	
	

}
