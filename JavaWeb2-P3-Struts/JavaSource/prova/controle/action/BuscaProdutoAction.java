package prova.controle.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import prova.controle.form.BuscaForm;
import prova.modelo.dao.ProdutoDAO;

public class BuscaProdutoAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
 
		BuscaForm formBusca = (BuscaForm)form ;
		
		request.setAttribute("produtos", ProdutoDAO.getInstance().buscarProdutos(formBusca.getBusca()) );

		return mapping.findForward("exibirProdutos");
	}

	

}
