package ocjp;

public class TestePassagemValor {

	private class ClasseTeste {
		int valor = 0;

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}

	}

	void testar() {

		ClasseTeste classe1 = new ClasseTeste();

		classe1.setValor(4);

		modificarValor(classe1);

		System.out.println("valor da classe fora do método : " + classe1.getValor());

	}

	void modificarValor(ClasseTeste classe) {

		classe = new ClasseTeste();

		classe.setValor(3);

		System.out.println("valor da classe do método : " + classe.getValor());

	}

	public static void main(String[] args) {
		TestePassagemValor teste = new TestePassagemValor();
		teste.testar();

	}
}
