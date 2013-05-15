package jndi;

import java.util.Properties;
import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class BuscaArquivoJNDI {

	static boolean achou;

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.FSContextFactory");
		props.put(Context.PROVIDER_URL, "file:///");

		try {
			Context ctx = new InitialContext(props);
			System.out.println("Contexto obetido com sucesso");

			if (args[1].equals("-t")) {              
				buscaTodosArquivo(ctx, 1, args[0]);
			}

			if (args[1].equals("-p")) {
				buscaArquivo(ctx, 1, args[0]);
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}

		if (!achou) {
			System.out.println("não encontrou");
		}

		System.out.println("Finalizou");

	}
   
	/**
	 * busca apenas um arquivo com o respectivo nome
	 * @param ctx
	 * @param i
	 * @param busca
	 * @throws NamingException
	 */
	private static void buscaArquivo(Context ctx, int i, String busca)
			throws NamingException {

		NamingEnumeration ne = ctx.listBindings("");

		while (ne.hasMore() && !achou) {

			Binding coisa = (Binding) ne.next();

			if (coisa.getName().equals(busca)) {
				System.out.println("Achou : " + coisa.getName() + " -> "
						+ coisa.getObject().getClass().getName());
				achou = true;
				return;

			}

			if (coisa.getObject().getClass().getName()
					.equals("com.sun.jndi.fscontext.FSContext")) {
				buscaArquivo((Context) coisa.getObject(), i + 2, busca);
			}

		}

	}
    
	/**
	 * busca todos os arquivos com o mesmo nome
	 * @param ctx
	 * @param i
	 * @param busca
	 * @throws NamingException
	 */
	private static void buscaTodosArquivo(Context ctx, int i, String busca)
			throws NamingException {

		NamingEnumeration ne = ctx.listBindings("");

		while (ne.hasMore()) {

			Binding coisa = (Binding) ne.next();

			if (coisa.getName().equals(busca)) {
				System.out.println("Achou : " + coisa.getName() + " -> "
						+ coisa.getObject().getClass().getName());
				achou = true;
			}

			if (coisa.getObject().getClass().getName()
					.equals("com.sun.jndi.fscontext.FSContext")) {
				buscaTodosArquivo((Context) coisa.getObject(), i + 2, busca);
			}

		}

	}
}
