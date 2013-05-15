package infnet;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ProdutorObjetoFila {

	public ProdutorObjetoFila() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	try{
		
		InitialContext initialContext = configuraContext();
		
		QueueConnectionFactory connectionFactory = (QueueConnectionFactory)
				initialContext.lookup("jms/RemoteConnectionFactory");
	
		QueueConnection queueConnection = connectionFactory.createQueueConnection("usuarioRemoto","infnet123");
		
		QueueSession session = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = (Queue) initialContext.lookup("jms/queue/filaTeste");
		
		QueueSender sender = session.createSender(queue);				
		
		ObjectMessage objectMessage = session.createObjectMessage();
		
		Carro carro = new Carro("Carro 1", "Prata", "Y83555BR");
		
		objectMessage.setObject(carro);
		
		sender.send(objectMessage);
		
	} catch (NamingException e ) {			
		e.printStackTrace();
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

private static InitialContext configuraContext() throws NamingException {
	Properties props = new Properties();
	props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
	props.put(Context.PROVIDER_URL, "remote://localhost:4447");
	props.put(Context.SECURITY_PRINCIPAL, "usuarioRemoto");
	props.put(Context.SECURITY_CREDENTIALS, "infnet123");
	InitialContext initialContext = new InitialContext(props);
	return initialContext;
}

}
