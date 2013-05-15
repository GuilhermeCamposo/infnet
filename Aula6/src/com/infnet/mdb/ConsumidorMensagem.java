package com.infnet.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.infnet.pojo.Usuario;

/**
 * Message-Driven Bean implementation class for: ConsumidorMensagem
 * 
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/test") })
public class ConsumidorMensagem implements MessageListener {

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		ObjectMessage objMsg = (ObjectMessage) message;
		try {
			System.out
					.println("<<<<<< Recebendo mensagem com o usuario com nome "
							+ ((Usuario) objMsg.getObject()).getNome());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
