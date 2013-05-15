package trabalho.modelo.entidades;

import java.io.Serializable;


public class Medico extends Funcionario implements Serializable{
	

	private static final long serialVersionUID = 887630169981774099L;

	
	private String especialidade ;

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	
	


	
	
	

}
