package jndi;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;


public class InitCtx {

   public static void main(String [] args) {

      try {

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
        props.put(Context.PROVIDER_URL, "file:///");

         Context ctx = new InitialContext(props);
         System.out.println("O contexto foi obtido com sucesso: " + ctx.getNameInNamespace());
      }
      catch(Exception e) {

         System.out.println("O contexto nao pode ser obtido");
      }
   }
}
