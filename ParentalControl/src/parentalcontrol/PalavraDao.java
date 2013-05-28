/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parentalcontrol;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilhermeluizcamposodossantossilva
 */
public class PalavraDao {
    
    public static void salvarPalavra(String palavra) {
        try {
            
            System.out.println("Comecou");
            
            Connection conn = ConexaoUtil.getConexao();
            Statement stm = conn.createStatement();
            String query = "INSERT INTO palavras VALUES('" + palavra + "') ";
            
            stm.executeUpdate(query);
            System.out.println("Terminou");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static  List<String> buscarPalavras() {
        List<String> lista = new ArrayList<String>();
        
        try {
            String query = "Select palavra from palavras";
            
            Connection conn = ConexaoUtil.getConexao();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next()) {
                String palavra = rs.getString("palavra");
                
                lista.add(palavra);
            }
            
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
