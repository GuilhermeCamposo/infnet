package com.infnet.jms;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.infnet.pojo.Usuario;

/**
 * Session Bean implementation class ProdutorDeMensagem
 */
@Stateless
public class ProdutorDeMensagem {

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/queue/test")
	private Destination destination;
	
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;
	
	@PostConstruct
	public void init() {
		try{
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			messageProducer = session.createProducer(destination);
		}catch(JMSException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@PreDestroy
	public void destroy(){
		if(connection != null){
			try{
				connection.close();
			}catch(JMSException e){
				e.printStackTrace();
			}
		}
	}
	
	public void enviarMensagem(Usuario usuario){
		ObjectMessage message;
		try{
			message = session.createObjectMessage(usuario);
			messageProducer.send(message);
		}catch(JMSException e){
			e.printStackTrace();
		}
	}
}
