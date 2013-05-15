package infnet;

import java.util.Enumeration;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FilaBrowser {

	public FilaBrowser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {				

			InitialContext initialContext = configuraContext();

			QueueConnectionFactory connectionFactory = (QueueConnectionFactory)
					initialContext.lookup("jms/RemoteConnectionFactory");

			QueueConnection queueConnection = connectionFactory.createQueueConnection("usuarioRemoto","infnet123");

			QueueSession session = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

			Queue queue = (Queue) initialContext.lookup("jms/queue/filaTeste");

			QueueBrowser browser = session.createBrowser(queue);
			
			Enumeration<Message> enumeration = browser.getEnumeration();
			
			Message message = null;
			while( enumeration.hasMoreElements() ){
				message = enumeration.nextElement();
				if( message instanceof TextMessage ){
					System.out.println("Mensagem texto: "+ 
							((TextMessage)message).getText());
				}else if( message instanceof ObjectMessage ){
					ObjectMessage objectMessage = (ObjectMessage) message;
		    		Carro carro = (Carro) objectMessage.getObject();
		    		System.out.println("-----------------------------------");
		    		System.out.println("Carro: "+ carro.getModelo());
		    		System.out.println("Cor: "+ carro.getCor());
		    		System.out.println("Chassi: "+ carro.getChassi());
		    		System.out.println("-----------------------------------");
				}
			}
			
			
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
