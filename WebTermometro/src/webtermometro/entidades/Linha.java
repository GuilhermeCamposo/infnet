package webtermometro.entidades;

import org.joda.time.DateTime;

public class Linha {
	
	public String cliente;
	public DateTime dataAcesso;
	
	public Linha(String cliente, DateTime dataAcesso) {
		super();
		this.cliente = cliente;
		this.dataAcesso = dataAcesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((dataAcesso == null) ? 0 : dataAcesso.hashCode());
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
		Linha other = (Linha) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataAcesso == null) {
			if (other.dataAcesso != null)
				return false;
		} else if (!dataAcesso.equals(other.dataAcesso))
			return false;
		return true;
	}

	

	

}
