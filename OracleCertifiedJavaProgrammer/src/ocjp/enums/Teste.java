package ocjp.enums;

public enum Teste   {
   
	A("primeiro"){ void testandoLocura() { System.out.println("out");}} , B("segundo");
	
	String ordem;
	
	private Teste(String ordem) {
	    this.ordem = ordem;
	 //   int i[] = new int[2] {1, 2};
	 //   int b[4] = { 1, 2, 3, 4 };
	    int[] c[] = { { 1, 2 }, { 1 }, {}, { 1, 2, 3 } };
	}
	
	enum TESTE2{A{}, B , C}
	
private	void fazAlgo( Object... obejto ){
		System.out.println("teste");
		
		
	}
	
static enum TEstefora{a,b; enum March{a}}

}

