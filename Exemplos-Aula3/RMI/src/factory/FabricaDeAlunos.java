package factory;
import java.rmi.*;

public interface FabricaDeAlunos extends Remote {

	public Aluno create(long id) throws RemoteException;

	public void destroy(long id) throws RemoteException;

	public Aluno find(long id) throws RemoteException;
}
