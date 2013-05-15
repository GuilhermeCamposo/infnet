package infnet.bean.client;

import infnet.servico.MensageiroAssincronoRemoto;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClienteSBAssincrono {

	private static String url = "consumidor-ear/consumidor-ejb/MensageiroAssincronoBean!infnet.servico.MensageiroAssincronoRemoto";
	
	public ClienteSBAssincrono() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {				
			InitialContext initialContext = configuraContext();		
			MensageiroAssincronoRemoto mensageiro = 
					(MensageiroAssincronoRemoto) initialContext					
					.lookup(url);			
			System.out.println("Realizando Chamada Assíncrona");
			Future<String> retorno = mensageiro.enviarMensagem("Chamada Assíncrona: minha Mensagem");
			while( !retorno.isDone() ){
				System.out.println("Fazendo algo enquanto não há retorno");
			}
			System.out.println("Chegou mensagem!");
			System.out.println("Mensagem do host: "+ retorno.get());

		} catch (NamingException e ) {			
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static InitialContext configuraContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		props.put(Context.PROVIDER_URL, "remote://localhost:4447");
		props.put(Context.SECURITY_PRINCIPAL, "teste");
		props.put(Context.SECURITY_CREDENTIALS, "teste123");
		props.put("jboss.naming.client.ejb.context", true);
		InitialContext initialContext = new InitialContext(props);
		return initialContext;
	}

}
