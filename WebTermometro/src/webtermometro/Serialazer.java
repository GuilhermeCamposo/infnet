/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webtermometro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import webtermometro.visao.ParametrizacaoFrame;
import webtermometro.visao.TelaPrincipalFrame;

/**
 *
 * @author guilhermeluizcamposodossantossilva
 */
public class Serialazer {
    
    public static void serializar(String nomeArquivo , Object objeto){
   
        FileOutputStream f_out;
        try {
            f_out = new FileOutputStream(nomeArquivo);

            ObjectOutputStream obj_out = new ObjectOutputStream(f_out);

            obj_out.writeObject(objeto);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParametrizacaoFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParametrizacaoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    public static Object deserializar(String nomeArquivo){
    
        FileInputStream f_in;
        try {
            f_in = new FileInputStream(nomeArquivo);

            // Read object using ObjectInputStream
            ObjectInputStream obj_in =
                    new ObjectInputStream(f_in);


        return obj_in.readObject();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaPrincipalFrame.class.getName()).log(Level.INFO, "Criara novo arquivo de parametrizacao");
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
