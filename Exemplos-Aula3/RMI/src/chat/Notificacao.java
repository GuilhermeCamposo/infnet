package chat;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notificacao extends Remote, Serializable{

	public void enviarMensagemEntrada(String nome) throws RemoteException;

	public void enviarMensagemTexto(String nome, String mensagem) throws RemoteException;

	public void enviarMensagemSaida(String nome) throws RemoteException;

	public String getNome(); //não é chamado remotamente

	public void setNome(String s) throws RemoteException;
}
