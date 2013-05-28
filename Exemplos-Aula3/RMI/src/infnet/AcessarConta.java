package infnet;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class AcessarConta extends UnicastRemoteObject
                          implements IAcessarConta
{
	public AcessarConta() throws RemoteException
	{

	}

	public ContaCorrente acessar(String nome, String senha) throws RemoteException
	{
		System.out.println("Autenticando conta corrente de: " + nome);

		return new ContaCorrente();
	}

	public double consultar(ContaCorrente conta) throws RemoteException
	{
		System.out.println("Consultando conta.");

		return 100;
	}

	public boolean depositar(double valor) throws RemoteException
	{

		return false;
	}

	public boolean sacar(double valor) throws RemoteException
	{

		return false;
	}


	public static void main(String args[]) throws Exception
	{
		// Iniciar RMIREGISTRY na porta 1099
	    System.out.println("Iniciando RMIRegistry");
    	LocateRegistry.createRegistry(1099);

    	// Criar objeto
		AcessarConta objRemoto = new AcessarConta();

		// Associar o objeto ao RMIREGISTRY
		Naming.rebind("rmi://localhost:1099/AcessarConta", objRemoto);

		System.out.println("Servidor pronto");
	}
}
