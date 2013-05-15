package ocjp;

public class AmpliacaoAutoboxing {
	
	
	
	void go(int a){System.out.println("inteiro");}
	
	//void go(long a){ System.out.println("longo"); }
	
	void go(Double a){ System.out.println("double"); }
	
	
	 void teste(){		 
		 
		 int inteiro = 01;
		 char tchar ='1';
		 
		 inteiro =  tchar;
		 
		 go(35);//imprimira inteiro		 
		 go(new Byte("5"));//imprimira inteiro
	//	 go(new Float("3.5f")); não existe ampliação de wrapper
		 go(20.5);
		 
	 }

	 public static void main(String[] args) {
		AmpliacaoAutoboxing amp = new AmpliacaoAutoboxing();
		
		amp.teste();
	}
}
