package trabalho.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "conta")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Normal")
@DiscriminatorColumn(name = "tipo_conta", discriminatorType = DiscriminatorType.STRING)
public class Conta implements Serializable {

	private static final long serialVersionUID = -4691814320813232758L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numero;

	@ManyToMany(mappedBy = "contas", targetEntity = Cliente.class, fetch=FetchType.EAGER)
	private Set<Cliente> clientes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agencia", nullable = false)
	private Agencia agencia;

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numero ^ (numero >>> 32));
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
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	

}
