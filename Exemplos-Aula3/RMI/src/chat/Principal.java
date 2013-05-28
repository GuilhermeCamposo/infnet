package chat;

import infnet.AcessarConta;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Principal extends UnicastRemoteObject implements Chat{

	private Collection<Notificacao> threadList = new ArrayList<Notificacao>();
	
	public Principal() throws RemoteException{
	}

	@Override
	public void entrar(Notificacao notificacao, String nome)
			throws RemoteException {
		threadList.add(notificacao);
		for (Iterator i = threadList.iterator();
				i.hasNext();) {
			Notificacao cliente = (Notificacao)i.next();
			cliente.enviarMensagemEntrada(notificacao.getNome());
		}		
	}

	@Override
	public void falar(Notificacao notificacao, String texto) throws RemoteException {
		for (Iterator i = threadList.iterator();
				i.hasNext();) {
			Notificacao cliente = (Notificacao)i.next();
			cliente.enviarMensagemTexto(notificacao.getNome(), texto);
		}		
	}

	@Override
	public void deixar(Notificacao notificacao)
			throws RemoteException {
		for (Iterator i = threadList.iterator();
				i.hasNext();) {
			Notificacao cliente = (Notificacao)i.next();
			cliente.enviarMensagemSaida(notificacao.getNome());
		}		
	}

	public static void main(String[] args) {
		try {
			System.out.println("Iniciando RMIRegistry");
			

			// Iniciar RMIREGISTRY na porta 1099		    
	    	//LocateRegistry.createRegistry(1099);
			
	    	// Criar objeto
	    	Principal servidor = new Principal();
	    	
			Naming.rebind("Principal", servidor);
				    		
			System.out.println("Servidor pronto");
			
		}
		catch (java.net.MalformedURLException e) {
			System.out.println("Malformed URL "
					+ e.toString());
		}
		catch (RemoteException e) {
			System.out.println("Communication error " +
					e.toString());
		}
	}
}
