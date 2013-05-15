package trabalho.visao.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import trabalho.modelo.dao.PacienteDao;
import trabalho.modelo.entidades.Paciente;
import trabalho.visao.util.Mensagens;

public class CadastroPacienteBean extends Paciente{
	
	
	public String cadastrarPaciente(){
		
		Paciente paciente = new Paciente();
		
		paciente.setCpf(getCpf());
		paciente.setNome(getNome());
		paciente.setTelefone(getTelefone());
				
		PacienteDao.getInstance().cadastrarPaciente(paciente);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagens.getText("msgs", "register.sucess"), null)) ;
		
		return null ;
	}

}
