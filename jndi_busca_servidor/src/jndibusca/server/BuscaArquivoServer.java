package jndibusca.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import jndibusca.busca.BuscaJNDI;
import jndibusca.interfaces.IBuscaArquivo;

public class BuscaArquivoServer {

	public BuscaArquivoServer() {

		try {
			BuscaJNDI busca = new BuscaJNDI();

			IBuscaArquivo stub = (IBuscaArquivo) UnicastRemoteObject.exportObject(busca, 0);

			Registry registry = LocateRegistry.createRegistry(1099);  

			registry.bind("buscaArquivo", stub);

			System.out.println("Serviço buscaArquivo ativo .");
		} catch (RemoteException e) {

			e.printStackTrace();
		} catch (AlreadyBoundException e) {
	
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BuscaArquivoServer();
	}
}
