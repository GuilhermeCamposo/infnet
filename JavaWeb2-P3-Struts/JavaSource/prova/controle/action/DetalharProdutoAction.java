package prova.controle.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import prova.modelo.dao.ProdutoDAO;

public class DetalharProdutoAction extends Action {
  
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		request.setAttribute("produto", ProdutoDAO.getInstance().buscarProduto(Integer.valueOf( request.getParameter("id") ) ) );

		return mapping.findForward("detalhar");
	}

	
}
