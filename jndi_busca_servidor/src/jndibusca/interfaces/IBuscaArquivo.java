package jndibusca.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBuscaArquivo extends Remote{
    
	int BUSCA_UM = 1 ;
	int BUSCA_TODOS = 2 ;
	
	String busca(String arquivo, int tipoPesquisa) throws RemoteException;
	
}
