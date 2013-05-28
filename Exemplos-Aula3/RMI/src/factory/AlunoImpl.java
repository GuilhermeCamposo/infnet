package factory;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class AlunoImpl extends UnicastRemoteObject implements Aluno {

   private long id;
   private String nome;

   public AlunoImpl(long id) throws RemoteException {

      this.id = id;
   }

   public void setNome(String nome) throws RemoteException {

      this.nome = nome;
   }

   public String getNome() throws RemoteException {

      return this.nome;
   }
}
