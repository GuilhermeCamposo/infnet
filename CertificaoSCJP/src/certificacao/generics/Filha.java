package certificacao.generics;

public class Filha<E> extends Super<E> implements ITeste<E>{
	
	static void teste(){
		System.out.println("teste");
	}

	@Override
	public E testar() {
		// TODO Auto-generated method stub
		return null;
	}

}
