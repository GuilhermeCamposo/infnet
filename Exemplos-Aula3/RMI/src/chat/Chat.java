package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote{
	public void entrar(Notificacao notificacao, String nome) throws RemoteException;
	public void falar(Notificacao notificacao, String texto) throws RemoteException;
	public void deixar(Notificacao notificacao) throws RemoteException;
}
