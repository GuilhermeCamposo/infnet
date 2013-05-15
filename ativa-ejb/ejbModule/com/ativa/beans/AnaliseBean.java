package com.ativa.beans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ativa.daos.PropostaDao;
import com.ativa.daos.WorkFlowDao;
import com.ativa.entidades.Gerente;
import com.ativa.entidades.Proposta;
import com.ativa.entidades.StatusAtiva;
import com.ativa.interfaces.IAnaliseProposta;

@Stateless
@Remote(IAnaliseProposta.class)
public class AnaliseBean implements IAnaliseProposta {

	private static final long serialVersionUID = 4460789989144178407L;

	@Override
	public List<Proposta> buscarPropostasParaAnalise(Gerente gerente)
			throws Exception {
		if (gerente.isPermissaoAnalise()) {
			return PropostaDao.getInstance().buscarPropostaEmAnalise();
		} else {
			throw new Exception();
		}
	}

	@Override
	public void rejeitarProposta(Proposta proposta, Gerente gerente) {
		if (gerente.isPermissaoAnalise()) {
			WorkFlowDao.getInstance().salvarAlteracao(proposta, gerente,
					StatusAtiva.REJEITADA);
			proposta.setStatusAtiva(StatusAtiva.REJEITADA);
			PropostaDao.getInstance().salvarProposta(proposta);
			System.out.println("Proposta Rejeitada com Sucesso");
		}
	}

	@Override
	public void preAprovarProposta(Proposta proposta, Gerente gerente) {
		if (gerente.isPermissaoAnalise()) {
			WorkFlowDao.getInstance().salvarAlteracao(proposta, gerente,
					StatusAtiva.PRE_APROVADA);
			proposta.setStatusAtiva(StatusAtiva.PRE_APROVADA);
			PropostaDao.getInstance().salvarProposta(proposta);
System.out.println("Proposta Aprovada com Sucesso");
		}
	}
}
