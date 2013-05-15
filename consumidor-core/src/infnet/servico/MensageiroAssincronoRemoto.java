package infnet.servico;

import java.io.Serializable;
import java.util.concurrent.Future;

import javax.ejb.Asynchronous;


public interface MensageiroAssincronoRemoto extends Serializable {
	
	@Asynchronous
	Future<String> enviarMensagem(String mensagem);	
	
	void sender(String mensagem);

}
