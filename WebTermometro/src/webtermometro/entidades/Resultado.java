/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webtermometro.entidades;

/**
 *
 * @author guilhermeluizcamposodossantossilva
 */
public class Resultado {

    private Double mediaAcesso;
    private Double tmpGastoMedio;
    private Double notaQuesitoTempo;
    private Double notaQuesitoAcesso;
    private Double notaGeral ;

    public Double getMediaAcesso() {
        return mediaAcesso;
    }

    public void setMediaAcesso(Double mediaAcesso) {
        this.mediaAcesso = mediaAcesso;
    }

    public Double getTmpGastoMedio() {
        return tmpGastoMedio;
    }

    public void setTmpGastoMedio(Double tmpGastoMedio) {
        this.tmpGastoMedio = tmpGastoMedio;
    }

    public Double getNotaQuesitoTempo() {
        return notaQuesitoTempo;
    }

    public void setNotaQuesitoTempo(Double notaQuesitoTempo) {
        this.notaQuesitoTempo = notaQuesitoTempo;
    }

    public Double getNotaQuesitoAcesso() {
        return notaQuesitoAcesso;
    }

    public void setNotaQuesitoAcesso(Double notaQuesitoAcesso) {
        this.notaQuesitoAcesso = notaQuesitoAcesso;
    }

    public Double getNotaGeral() {
        return notaGeral;
    }

    public void setNotaGeral(Double notaGeral) {
        this.notaGeral = notaGeral;
    }

    
}
