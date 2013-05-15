package p1.modelo.entidades;

public class Atendente extends Funcionario {
	
	
	public static final String  TURNO_MANHA =  "manhã" , TURNO_TARDE ="tarde" , TURNO_NOITE ="noite";
	
	
	private String turno ;
  
	private Funcionario funcionario ;
	

	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	

}
