package aula1.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConversao extends Remote {

	String toMaiusculo(String texto) throws RemoteException;

	String toMinusculo(String texto) throws RemoteException;

}
