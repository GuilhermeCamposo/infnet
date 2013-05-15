package jndibusca.busca;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import jndibusca.interfaces.IBuscaArquivo;


@SuppressWarnings("rawtypes")
public class BuscaJNDI   implements IBuscaArquivo{


	private static final long serialVersionUID = 4117523831032272054L;

	public BuscaJNDI() throws RemoteException {
		super();
	}

	static boolean achou;
	static String retorno = "";

	public String busca(String arquivo, int tipoPesquisa) {

		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.FSContextFactory");
		props.put(Context.PROVIDER_URL, "file:///");

		try {
			Context ctx = new InitialContext(props);
			System.out.println("Contexto obetido com sucesso");

			switch (tipoPesquisa) {
			case 1:
				buscaArquivo(ctx, 1, arquivo);
				break;

			default:
				buscaTodosArquivo(ctx, 1, arquivo);
				break;
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}

		if (!achou) {
			return "não encontrou";
		}

		return (retorno += "Finalizou");

	}

	/**
	 * busca apenas um arquivo com o respectivo nome
	 * 
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
						
				retorno = " \n Achou : " +  coisa.getName() + " -> "
						+ coisa.getObject().getClass().getName();
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
	 * 
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
				retorno += "Achou : " + coisa.getName() + " -> "
						+ coisa.getObject().getClass().getName();
				achou = true;
			}

			if (coisa.getObject().getClass().getName()
					.equals("com.sun.jndi.fscontext.FSContext")) {
				buscaTodosArquivo((Context) coisa.getObject(), i + 2, busca);
			}

		}

	}
}
