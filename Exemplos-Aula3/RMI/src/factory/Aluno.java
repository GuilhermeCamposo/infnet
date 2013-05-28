package factory;
import java.rmi.*;

public interface Aluno extends Remote {

   public void setNome(String nome) throws RemoteException;

   public String getNome() throws RemoteException;
}