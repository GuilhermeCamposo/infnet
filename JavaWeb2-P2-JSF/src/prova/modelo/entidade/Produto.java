package prova.modelo.entidade;

import java.io.Serializable;

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 5882791023749017891L;

	private int id ;
	
	private String nome ,  modelo ;
	
	private double preco ;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	

}
