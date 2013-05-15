package com.tarefajavap2.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remote do RMI.
 *
 */
public interface IServidor extends Remote{
	public Boolean pedidoRelatorio(String nome,String ipCliente) throws RemoteException;
}
