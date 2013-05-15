package infnet;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author guilherme
 *
 */
public class ProdutorTopico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		try {				
			
			InitialContext initialContext = configuraContext();
			
			TopicConnectionFactory connectionFactory = (TopicConnectionFactory)
					initialContext.lookup("jms/RemoteConnectionFactory");
		
			TopicConnection topicConnection = connectionFactory.createTopicConnection("usuarioRemoto","infnet123");
			
			TopicSession session = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic = (Topic) initialContext.lookup("jms/topic/topicoTeste");
			
			TopicPublisher publisher = session.createPublisher(topic);				
			
			TextMessage textMessage = session.createTextMessage();
			
			textMessage.setText("Mensagem tópico 1");
			
			publisher.send(textMessage);
			
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
