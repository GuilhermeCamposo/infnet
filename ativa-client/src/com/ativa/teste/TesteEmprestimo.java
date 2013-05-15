package com.ativa.teste;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ativa.entidades.Contrato;
import com.ativa.entidades.Funcionario;
import com.ativa.entidades.Gerente;
import com.ativa.entidades.Proposta;
import com.ativa.entidades.Tomador;
import com.ativa.interfaces.IAnaliseProposta;
import com.ativa.interfaces.IEmprestimo;

public class TesteEmprestimo {

	private static String url_Emprestimo = "/ativa-ear/ativa-ejb/EmprestimoBean!com.ativa.interfaces.IEmprestimo";
	private static String urlAnalise = "/ativa-ear/ativa-ejb/AnaliseBean!com.ativa.interfaces.IAnaliseProposta";

	public static void main(String[] args) {
		try {
			InitialContext initialContext = configuraContext();

			//testarSolicitacaoEmprestimo(initialContext);
			//testarSolicitacaoRefinaciamento(initialContext);
			//testarPreAprovarProposta(initialContext);
			//testarRejeitarProposta(initialContext);
			//testarBuscarProposta(initialContext);
			
			IEmprestimo bean = (IEmprestimo) initialContext.lookup(url_Emprestimo);
			bean.mocks();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void testarRejeitarProposta(InitialContext context)
			throws Exception {
		Gerente gerente = new Gerente();
		gerente.setPermissaoAnalise(true);
		gerente.setNome("Marcos Paulo");

		IAnaliseProposta bean = (IAnaliseProposta) context.lookup(urlAnalise);
		List<Proposta> propostas = bean.buscarPropostasParaAnalise(gerente);

		bean.rejeitarProposta(propostas.get(0), gerente);
	}

	private static void testarPreAprovarProposta(InitialContext context)
			throws Exception {
		Gerente gerente = new Gerente();
		gerente.setPermissaoAnalise(true);
		gerente.setNome("Marcos Paulo");

		IAnaliseProposta bean = (IAnaliseProposta) context.lookup(urlAnalise);
		List<Proposta> propostas = bean.buscarPropostasParaAnalise(gerente);

		bean.preAprovarProposta(propostas.get(0), gerente);
	}

	private static void testarSolicitacaoEmprestimo(
			InitialContext initialContext) throws NamingException {
		IEmprestimo bean = (IEmprestimo) initialContext.lookup(url_Emprestimo);

		Funcionario corretor = new Funcionario();
		corretor.setNome("Rodrigo Almeida");

		Tomador tomador = new Tomador();
		tomador.setCpf("00011123455");
		tomador.setNome("Roberio da silva sauro");
		tomador.setNomeMae("Ramilda Jo‹o Pessoa");

		Proposta proposta = new Proposta();

	//	proposta.setCorretor(corretor);
		proposta.setTomador(tomador);

		try {
			bean.solicitarEmprestimo(proposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testarSolicitacaoRefinaciamento(
			InitialContext initialContext) throws NamingException {
		IEmprestimo bean = (IEmprestimo) initialContext.lookup(url_Emprestimo);

		Proposta proposta = new Proposta();

		Contrato contrato = new Contrato();
		contrato.setAtivo(true);
	//	contrato.setPermiteRefinanciamento(true);

//		proposta.setContrato(contrato);

		try {
			bean.solicitarEmprestimo(proposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testarBuscarProposta(InitialContext initialContext)
			throws Exception {
		IEmprestimo bean = (IEmprestimo) initialContext.lookup(url_Emprestimo);

		Tomador tomador = new Tomador();
		tomador.setCpf("00011123455");
		tomador.setNome("Roberio da silva sauro");
		tomador.setNomeMae("Ramilda Jo‹o Pessoa");

		List<Proposta> proposta = bean.buscarStatusPropostaPorCliente(tomador);
		
		System.out.println("numero de proposta encontradas "+ proposta.size());
	}

	private static InitialContext configuraContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				org.jboss.naming.remote.client.InitialContextFactory.class
						.getName());
		props.put(Context.PROVIDER_URL, "remote://localhost:4447");
		props.put(Context.SECURITY_PRINCIPAL, "teste");
		props.put(Context.SECURITY_CREDENTIALS, "teste123");
		props.put("jboss.naming.client.ejb.context", true);
		InitialContext initialContext = new InitialContext(props);
		return initialContext;
	}

}
