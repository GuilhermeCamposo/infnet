package modelo;

import java.io.Serializable;

public class Endereco implements Serializable
{

	private int id;
	private String rua;
	private String bairro;
	private String identificador;
	private Pessoa pessoa;
	
	
	public Endereco(String rua, String bairro, String identificador) {
		this.rua = rua;
		this.bairro = bairro;
		this.identificador = identificador;
	}


	public Endereco() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", bairro=" + bairro
				+ ", identificador=" + identificador + "]";
	}
	
	
	
	
}
