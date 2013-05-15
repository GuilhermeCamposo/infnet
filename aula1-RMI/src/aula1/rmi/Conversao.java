package aula1.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Conversao extends UnicastRemoteObject implements IConversao {

	protected Conversao() throws RemoteException {
		super();
	}

	public static void main(String[] args) {

		try {
			Conversao conversao = new Conversao();
			Naming.rebind("converte", conversao);
			System.out.println("Ativo no servidor");
		} catch (RemoteException e) {

			e.printStackTrace();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public String toMaiusculo(String texto) {
		System.out.println("Recebi [ " + texto + "]");
		System.out.println("transformei [ " + texto.toUpperCase() + "]");
		return texto.toUpperCase();
	}

	@Override
	public String toMinusculo(String texto) {
		System.out.println("Recebi [ " + texto + "]");
		System.out.println("transformei [ " + texto.toLowerCase() + "]");
		return texto.toLowerCase();
	}

}
