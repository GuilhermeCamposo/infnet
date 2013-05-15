package trabalho.visao.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
/**
 * Classe utilitária para acesso ao resource bundle da aplicação
 * @author GuiLuiz
 *
 */
public class Mensagens {

	/**
	 * busca um texto no arquivo de propriedades
	 * 
	 * @param resourceBundleName o nome dado a um arquivo de propriedades
	 * @param resourceBundleKey  a chave para o texto
	 * @return
	 * @throws MissingResourceException
	 */
	public static String getText(String resourceBundleName,
			String resourceBundleKey) throws MissingResourceException {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = facesContext.getApplication()
				.getResourceBundle(facesContext, resourceBundleName);
		
		return bundle.getString(resourceBundleKey);
	}

}
