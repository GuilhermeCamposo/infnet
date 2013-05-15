package arvoreb;

import java.util.HashMap;

public class ArvoreB {

	private Pagina raiz;
	private int ordem;

	public ArvoreB(int ordem) {
		this.ordem = ordem;
		raiz = new Pagina();

		raiz.chaves.put(3, "raiz");

		Pagina pagina1 = new Pagina();
		pagina1.chaves.put(1, "amarelo");
		pagina1.chaves.put(2, "vermelho");

		Pagina pagina2 = new Pagina();
		pagina2.chaves.put(4, "verde");
		pagina2.chaves.put(5, "azul");

		raiz.setPaginaFilha(pagina1);
		raiz.setPaginaFilha(pagina2);

	}

	public String buscarValor(int chave) {
		return buscar(chave, raiz);
	}

	private String buscar(int chave, Pagina pagina) {

		// carrega em memoria primaria pagina apontado por ponteiroRaiz
		// procura chave na pagina carregada
		String valor = pagina.chaves.get(chave);

		if (valor != null) {
			return valor;
		}
		// ponteiro para a próxima página da possível ocorrência da chave
		if (pagina.filhas != null) {

			Integer[] ponteiro = new Integer[pagina.chaves.keySet().size()];
			pagina.chaves.keySet().toArray(ponteiro);

			for (int i = 0; i < ponteiro.length; i++) {
				if (chave < ponteiro[i]) {
					return buscar(chave, pagina.filhas[i]);
				} else if (i + 1 == ponteiro.length) {
					return buscar(chave, pagina.filhas[++i]);
				}
			}

		}

		return "nada encontrado";
	}


	private class Pagina {

		HashMap<Integer, String> chaves;
		Pagina[] filhas;

		Pagina() {
			chaves = new HashMap<>(ordem - 1);

		}

		void setPaginaFilha(Pagina pagina) {
			if (filhas == null) {
				filhas = new Pagina[ordem];
			}
			for (int i = 0; i < filhas.length; i++) {
				if (filhas[i] == null) {
					filhas[i] = pagina;
					break;
				}
			}

		}

	}

}