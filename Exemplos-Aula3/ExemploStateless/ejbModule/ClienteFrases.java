import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.infnet.controller.FraseDoDia;
import com.infnet.controller.FraseDoDiaBean;


public class ClienteFrases {

	public static void main(String[] args) throws NamingException {
		FraseDoDia frase2 = new FraseDoDiaBean();
		
		Context contexto = new InitialContext();
		//FraseDoDia frase  = (FraseDoDia) contexto.lookup("FraseDoDiaBean/remote");
		Object obj = contexto.lookup("FraseDoDiaBean");
		
		//Passo obrigatório de acordo com a especificação Java EE
		//Conversão de um objeto de rede para um objeto do tipo FraseDoDia
		FraseDoDia frase = (FraseDoDia) PortableRemoteObject.narrow(obj, FraseDoDia.class);
		
		System.out.println(frase.pegarFrase());
		
		System.out.println("Objeto Remoto: " + frase);
		System.out.println("Objeto Local: " + frase2);

		System.out.println(frase.pegarFrase());
	}
	
}
