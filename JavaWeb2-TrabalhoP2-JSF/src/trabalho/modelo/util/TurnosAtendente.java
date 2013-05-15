package trabalho.modelo.util;

public enum TurnosAtendente {
	
   MANHA("Manhã") , TARDE("Tarde") , NOITE("Noite") ;
   
   private String valor ;
   
    private TurnosAtendente(String string) {
		valor = string ;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

    
    
    
}
