package trabalho.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "movimento")
public class Movimento implements Serializable {

	private static final long serialVersionUID = -1947145733337623061L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "conta", nullable = false)
	private Conta conta;

	private double valor;

	private Timestamp data;

	public Conta getConta() {
		return conta;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	

	

}
