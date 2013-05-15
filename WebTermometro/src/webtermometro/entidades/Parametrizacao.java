/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webtermometro.entidades;

import java.io.Serializable;

/**
 *
 * @author guilhermeluizcamposodossantossilva
 */
public class Parametrizacao implements Serializable {
    
    	private  Double tmpGastoMedioSecIdeal;
	private  Double numAcessoMedioDiaIdeal;
	private  Integer pesoTempo ;
	private  Integer pesoAcesso ;

    public Double getTmpGastoMedioSecIdeal() {
        return tmpGastoMedioSecIdeal;
    }

    public void setTmpGastoMedioSecIdeal(Double tmpGastoMedioSecIdeal) {
        this.tmpGastoMedioSecIdeal = tmpGastoMedioSecIdeal;
    }

    public Double getNumAcessoMedioDiaIdeal() {
        return numAcessoMedioDiaIdeal;
    }

    public void setNumAcessoMedioDiaIdeal(Double numAcessoMedioDiaIdeal) {
        this.numAcessoMedioDiaIdeal = numAcessoMedioDiaIdeal;
    }

    public Integer getPesoTempo() {
        return pesoTempo;
    }

    public void setPesoTempo(Integer pesoTempo) {
        this.pesoTempo = pesoTempo;
    }

    public Integer getPesoAcesso() {
        return pesoAcesso;
    }

    public void setPesoAcesso(Integer pesoAcesso) {
        this.pesoAcesso = pesoAcesso;
    }

    
          
    
}
