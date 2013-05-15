package infnet.servico.sb;

import infnet.servico.MensageiroAssincronoRemoto;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MensageiroAssincronoBean
 */
@Stateless
@Remote(MensageiroAssincronoRemoto.class)
public class MensageiroAssincronoBean implements MensageiroAssincronoRemoto {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public MensageiroAssincronoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	@Asynchronous
	public Future<String> enviarMensagem(String mensagem) {
		System.out.println("Mensagem recebida: "+ mensagem);
		try {
			//Gastando tempo
			for(int i = 0 ; i < 101; i++){
				Thread.sleep(5);
			}			
			System.out.println("Retornando mensagem");
			return new AsyncResult<String>("ok");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new AsyncResult<String>("Erro");
		}
		
	}

	@Override
	public void sender(String mensagem) {
		System.out.println(mensagem);
		
	}

	

}
