package infnet.bean.client;

import infnet.servico.Mensageiro;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClienteMensageiro {

	private static String url = "consumidor-ear/consumidor-ejb/MensageiroBean!infnet.servico.Mensageiro";
	
	public ClienteMensageiro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InitialContext initialContext;
		Mensageiro mensageiro;
		try {
			initialContext = configuraContext();
			mensageiro = (Mensageiro) initialContext					
					.lookup(url);
			mensageiro.enviarMensagemTextoParaFila("Mensagem do Cliente");
			System.out.println("Mensagem enviada com sucesso");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

	}
	private static InitialContext configuraContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		props.put(Context.PROVIDER_URL, "remote://localhost:4447");
		props.put(Context.SECURITY_PRINCIPAL, "usuarioRemoto");
		props.put(Context.SECURITY_CREDENTIALS, "infnet123");
		props.put("jboss.naming.client.ejb.context", true);
		InitialContext initialContext = new InitialContext(props);
		return initialContext;
	}

}
