package trabalho.visao.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import trabalho.modelo.dao.AtendenteDao;
import trabalho.modelo.dao.ConsultaDao;
import trabalho.modelo.dao.MedicoDao;
import trabalho.modelo.entidades.Atendente;
import trabalho.modelo.entidades.Medico;
import trabalho.visao.util.Mensagens;

public class AgendamentoConsultaBean {

	private SelectItem[] lstMedico;
	private SelectItem[] lstAtendente;
	private Integer medicoId = 0 ;
	private Integer atendenteId = 0 ;
    private Atendente atendente ;
    private String pacienteCPF;
    
    	
	
	public AgendamentoConsultaBean() {
		carregaLstMedico();
		carregaLstAtendente();
	}

	private void carregaLstMedico() {

		List<Medico> lst = MedicoDao.getInstance().buscarTodosMedicos();

		lstMedico = new SelectItem[lst.size()];

		int i = 0;
		for (Medico medico : lst) {
			
			lstMedico[i] = new SelectItem(medico.getMatricula(), medico.getNome());
           
			i++;
		}

	}


	private void carregaLstAtendente() {

		List<Atendente> lst = AtendenteDao.getInstance().buscarTodosAtendentes();

		lstAtendente = new SelectItem[lst.size()];

		int i = 0;
		for (Atendente atendente : lst) {
			
			lstAtendente[i] = new SelectItem(atendente.getMatricula(), atendente.getNome());
           
			i++;
		}

	}
	
	
	
	
	public String getPacienteCPF() {
		return pacienteCPF;
	}

	public void setPacienteCPF(String pacienteCPF) {
		this.pacienteCPF = pacienteCPF;
	}

	public String agendarConsulta() {
		
		ConsultaDao.getInstance().agendarConsulta(medicoId, atendenteId, pacienteCPF.trim());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagens.getText("msgs", "register.sucess"), null)) ;
				
		return null;
	}

	public SelectItem[] getLstMedico() {
		return lstMedico;
	}

	public void setLstMedico(SelectItem[] lstMedico) {
		this.lstMedico = lstMedico;
	}

	public Integer getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Integer medicoId) {
		this.medicoId = medicoId;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public SelectItem[] getLstAtendente() {
		return lstAtendente;
	}

	public void setLstAtendente(SelectItem[] lstAtendente) {
		this.lstAtendente = lstAtendente;
	}

	public Integer getAtendenteId() {
		return atendenteId;
	}

	public void setAtendenteId(Integer atendenteId) {
		this.atendenteId = atendenteId;
	}
	
	
	

}
