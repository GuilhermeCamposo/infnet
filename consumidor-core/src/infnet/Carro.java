package infnet;

import java.io.Serializable;

public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public Carro(String modelo, String cor, String chassi) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.chassi = chassi;
	}

	private String modelo;
	
	private String cor;
	
	private String chassi;

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public String getChassi() {
		return chassi;
	}
	
	

}
