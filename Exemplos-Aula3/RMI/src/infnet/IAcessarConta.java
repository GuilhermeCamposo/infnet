package infnet;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAcessarConta extends Remote
{
	public ContaCorrente acessar(String nome, String senha) throws RemoteException;
	public boolean depositar(double valor) throws RemoteException;
	public boolean sacar(double valor) throws RemoteException;
	public double consultar(ContaCorrente conta) throws RemoteException;
}
