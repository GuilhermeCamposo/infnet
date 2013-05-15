package com.ativa.beans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ativa.daos.ContratoDao;
import com.ativa.daos.DefaultDao;
import com.ativa.daos.PropostaDao;
import com.ativa.entidades.Empresa;
import com.ativa.entidades.Proposta;
import com.ativa.entidades.StatusAtiva;
import com.ativa.entidades.Tomador;
import com.ativa.interfaces.IEmprestimo;


@Stateless
@Remote(IEmprestimo.class)
public class EmprestimoBean implements IEmprestimo {

	private static final long serialVersionUID = -6136375939951182025L;

	public EmprestimoBean() {
	}

	public void solicitarEmprestimo(Proposta proposta) throws Exception{
		
		if (proposta.getTomador() == null){
			throw new Exception("cliente n‹o ativo");
		}
		
		if(ContratoDao.getInstance().buscarContratoPorTomador(proposta.getTomador()) != null) {
			throw new Exception("cliente j‡ possui emprestimo ativo");
		}
		
		System.out.println("imprestimo solicitado");
		
		proposta.setStatusAtiva(StatusAtiva.EM_ANALISE);
		PropostaDao.getInstance().salvarProposta(proposta);
	}

	
	@Override
	public void solicitarRefinanciamento(Proposta proposta) {
//		if(proposta.getContrato().isPermiteRefinanciamento()){
//			PropostaDao.getInstance().salvarProposta(proposta);
//		}
	}

	@Override
	public List<Proposta> buscarStatusPropostaPorCliente(Tomador tomador)
			throws Exception {
		
		return PropostaDao.getInstance().buscarPropostaPorTomador(tomador);
	}

	@Override
	public void mocks() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("44556677");
		
		new DefaultDao().salvar(empresa);
		
	}

}
