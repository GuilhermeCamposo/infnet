package jndibusca;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import jndibusca.interfaces.IBuscaArquivo;

public class Teste {
	
	
	public static void main(String[] args) {
		
		try {
			IBuscaArquivo buscaArquivo = (IBuscaArquivo) Naming.lookup("buscaArquivo");
			
			System.out.println("Procurando arquivo");
			System.out.println(buscaArquivo.busca("catalina.policy", IBuscaArquivo.BUSCA_UM));
			
		} catch (MalformedURLException e) {
		
			e.printStackTrace();
		} catch (RemoteException e) {

			e.printStackTrace();
		} catch (NotBoundException e) {
		
			e.printStackTrace();
		}
		
	}
	

}
