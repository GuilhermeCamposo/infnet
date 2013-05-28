package jndi;
import java.util.Properties;
import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;

public class Browser {

   public static void main(String args[]) {

      try {

         Properties props = new Properties();
         props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
         props.put(Context.PROVIDER_URL, "file:///");
         Context inc = new InitialContext(props);
         displayContext(inc, 0);
      } 
      catch (Exception e) {

        e.printStackTrace();
      } 
   }

   private static void displayContext(Context ctx, int indent) throws Exception {

      NamingEnumeration ne = ctx.listBindings("");
      while (ne.hasMore()) {

         Binding thing = (Binding)ne.next();
         for (int i=0; i<indent; i++) System.out.print(" ");
         System.out.println(thing.getName());
         if (thing.getObject().getClass().getName().equals("com.sun.jndi.fscontext.FSContext"))
            displayContext((Context)thing.getObject(), indent + 2);
      }
   }
}
