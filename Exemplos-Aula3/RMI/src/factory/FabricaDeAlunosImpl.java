package factory;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class FabricaDeAlunosImpl extends UnicastRemoteObject implements FabricaDeAlunos {

   private Hashtable alunos;

   public FabricaDeAlunosImpl() throws RemoteException {

      alunos = new Hashtable();
   }

   public Aluno create(long id) throws RemoteException {

      AlunoImpl aluno = new AlunoImpl(id);
      alunos.put(new Long(id), aluno);
      return aluno;
   }

   public void destroy(long id) throws RemoteException {

      alunos.remove(new Long(id));
   }

   public Aluno find(long id) throws RemoteException {

      return (Aluno) alunos.get(new Long(id));
   }

   public static void main (String [] args) {
      try {

         FabricaDeAlunosImpl fdai = new FabricaDeAlunosImpl();
         Naming.rebind("Fabrica", fdai);
         System.out.println("A fabrica esta pronta...");
      }
      catch(Exception e) {
         System.err.println("Excecao no servidor - " + e.getMessage());
      }
   }
}
