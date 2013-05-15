package trabalho.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "conta_especial")
@Inheritance(strategy = InheritanceType.JOINED)
public class ContaEspecial extends Conta {
	
	private static final long serialVersionUID = 7771038373777203053L;
	
	@Column(name="limite_extra")
	private double limiteExtra;

	public double getLimiteExtra() {
		return limiteExtra;
	}

	public void setLimiteExtra(double limiteExtra) {
		this.limiteExtra = limiteExtra;
	}
	
	
	
	
}
