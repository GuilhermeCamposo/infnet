package jndi;
import java.io.File;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.jndi.fscontext.FSContext;



public class BuscaArquivo {

   public static void main(String [] args) {

      try {

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
        props.put(Context.PROVIDER_URL, "file:///");

         Context ctx = new InitialContext(props);
         System.out.println("O contexto foi obtido com sucesso");
                  
         FSContext pasta = (FSContext) ctx.lookup("temp");
         System.out.println(pasta.lookup("cpfs.txt"));
      }
      catch(NamingException e) {

    	  e.printStackTrace();
          System.out.println("O contexto nao pode ser obtido");
      }
   }
}
