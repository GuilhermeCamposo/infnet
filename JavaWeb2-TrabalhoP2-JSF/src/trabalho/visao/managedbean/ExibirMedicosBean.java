package trabalho.visao.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import trabalho.modelo.dao.MedicoDao;
import trabalho.modelo.entidades.Medico;

public class ExibirMedicosBean {

	private UIData tabela;
	private List<Medico> lstMedicos = new ArrayList<Medico>();

	public ExibirMedicosBean() {

		lstMedicos = MedicoDao.getInstance().buscarTodosMedicos();

	}

	public UIData getTabela() {
		return tabela;
	}

	public void setTabela(UIData tabela) {
		this.tabela = tabela;
	}

	/**
	 * exclui o médico selecionado na tabela e redireciona para mesma página ,
	 * para que a lista possa ser atualizada
	 * 
	 * @return
	 * @throws Exception
	 */
	public String excluir() throws Exception {

		Medico medico = (Medico) tabela.getRowData();

		MedicoDao.getInstance().deletarMedico(medico);

		return "exibirMedicos";
	}
	
   /**
    * seleciona o item na tabela e envia para tela de cadastro onde os dados serão alterados
    * @return
    */
	public String editar() {

		Medico medico = (Medico) tabela.getRowData();

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		request.getSession().setAttribute("medico", medico);

		return "cadastroMedico";

	}

	public List<Medico> getLstMedicos() {
		return lstMedicos;
	}

	public void setLstMedicos(List<Medico> lstMedicos) {
		this.lstMedicos = lstMedicos;
	}

}
