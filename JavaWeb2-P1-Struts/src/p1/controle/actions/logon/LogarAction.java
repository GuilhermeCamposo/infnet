package p1.controle.actions.logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import p1.controle.forms.logon.LogarForm;
import p1.modelo.dao.AtendenteDao;
import p1.modelo.dao.FuncionarioDao;
import p1.modelo.dao.MedicoDao;
import p1.modelo.entidades.Funcionario;

public class LogarAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LogarForm logarform = (LogarForm) form;
		
		ActionErrors errors = new ActionErrors();
		
		Funcionario funcionario = FuncionarioDao.getInstance()
				.buscarFuncionario(logarform.getSenha(), logarform.getLogin());

		if (funcionario == null) {
			errors.add("login", new ActionMessage("erro.logon.naocadastrado"));
			saveErrors( request, errors ); 
			return mapping.findForward("Login");
		} 


		if (logarform.getLogin().equals("admin")) {

			request.setAttribute("adm", logarform.getLogin());
			return mapping.findForward("menuPrincipal");

		}

		int matricula = funcionario.getMatricula();

		if (AtendenteDao.getInstance().buscarAtendente(matricula) != null) {

			request.setAttribute("atendente", logarform.getLogin());
			return mapping.findForward("menuPrincipal");
		}

		if (MedicoDao.getInstance().buscarMedico(matricula) != null) {

			request.setAttribute("medico", logarform.getLogin());
			return mapping.findForward("menuPrincipal");
		}

		return super.execute(mapping, form, request, response);
	}

}
