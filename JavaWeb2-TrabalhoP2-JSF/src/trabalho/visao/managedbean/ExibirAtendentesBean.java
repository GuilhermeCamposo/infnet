package trabalho.visao.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import trabalho.modelo.dao.AtendenteDao;
import trabalho.modelo.entidades.Atendente;

public class ExibirAtendentesBean {
	
	private UIData tabela;
	private List<Atendente> lstAtendentes = new ArrayList<Atendente>();
  
	public ExibirAtendentesBean() {
		lstAtendentes = AtendenteDao.getInstance().buscarTodosAtendentes();
	}
	
	
	public String excluir() throws Exception {

		Atendente atendente = (Atendente) tabela.getRowData();
		
		AtendenteDao.getInstance().deletarAtendente(atendente);

		return "exibirAtendentes";
	}
	
   
	public String editar(){ 
		
		Atendente atendente = (Atendente) tabela.getRowData();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		request.getSession().setAttribute("atendente", atendente);
		
		System.out.println( "botao editar do exibir Atendente bean " + request.hashCode());
			
		return "cadastroAtendente" ;
	}
	 
	
	
	
	public UIData getTabela() {	
		return tabela;
	}
	public void setTabela(UIData tabela) {
		this.tabela = tabela;
	}
	public List<Atendente> getLstAtendentes() {
	
		return lstAtendentes;
	}
	public void setLstAtendentes(List<Atendente> lstAtendentes) {
		this.lstAtendentes = lstAtendentes;
	}
	
	
	
	
	
	

}
