p\u0061ckage ocjp;

import ocjp.systemproperties.Util;

public cl\u0061ss Teste {

	int hexa = 0xff;
	long numLong = 2002L;
	double numDouble = 20.20d;
	double numDouble2 = 20.20D;
	char charUnicode = '\u004E';
	byte vbyte = 127;
   
	
    char \u0061 = 'a';
    ch\u0061r t ='a';

    
    private Teste(){
    	new  Util();
    }
	
    
	void teste() {

		vbyte += 7;

		usoVarArgs(3,4,5,6);
		
	}
	/*// */
	
	void usoVarArgs(int...args){
		System.out.println(args.length);
		
	}
	
	public static void main(String[] args) {
		
		Teste teste = new Teste();
		
		teste.teste();
		
	}
	
}
