package infnet.servico;

import java.io.Serializable;

public interface Mensageiro extends Serializable {
	
	void enviarMensagemTextoParaFila(String mensagem);

}
