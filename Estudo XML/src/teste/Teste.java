package teste;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;

public class Teste {
	
	
	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa("Guilherme", "Camposo");
		
		XStream xstream =  new XStream(new Xpp3DomDriver());
		
		
		String xml = xstream.toXML(pessoa);
		
		System.out.println("Xml Gerado :");
		System.out.println( xml);
		
		
	}

}
