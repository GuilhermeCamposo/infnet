package factory;
import java.rmi.*;

public class ClienteDaFabrica {

   public static void main(String [] args) {

      System.out.print("Acessando a Fabrica...");
      FabricaDeAlunos fabrica = null;
      try {

         fabrica = (FabricaDeAlunos) Naming.lookup("Fabrica");
         System.out.println("OK.");
      }
      catch(Exception e) {
      
         System.err.println("Excecao: " + e.getMessage());
      }

      System.out.print("Criando os alunos...");
      try {


         for(int i=1; i <= 100; i++) {

            Aluno aluno = fabrica.create(i);
            aluno.setNome("Aluno"+i);
         }
         System.out.println("OK.");
      }
      catch(Exception e) {
      
         System.err.println("Excecao: " + e.getMessage());
      }

      System.out.print("Qual o nome do setimo Aluno? ");
      try {

         Aluno aluno = fabrica.find(7);
         System.out.println(aluno.getNome());
      }
      catch(Exception e) {
      
         System.err.println("Excecao: " + e.getMessage());
      }

   }
}