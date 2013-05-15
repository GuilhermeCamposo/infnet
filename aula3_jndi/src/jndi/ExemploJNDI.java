package jndi;

import java.util.Properties;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class ExemploJNDI {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.FSContextFactory");
		props.put(Context.PROVIDER_URL, "file:///");

		try {
			Context ctx = new InitialContext(props);
			System.out.println("Contexto obetido com sucesso");

			displayContext(ctx, 1);

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	private static void displayContext(Context ctx, int i)
			throws NamingException {

		NamingEnumeration ne = ctx.listBindings("");
		while (ne.hasMore()) {
			Binding coisa = (Binding) ne.next();
			for (int j = 0; j < i; j++) {
				System.out.println("");
			}
			System.out.println(coisa.getName() + " -> "
					+ coisa.getObject().getClass().getName());

			if (coisa.getObject().getClass().getName()
					.equals("com.sun.jndi.fscontext.FSContext")) {
				displayContext((Context) coisa.getObject(), i + 2);
			}
		}

	}

}
