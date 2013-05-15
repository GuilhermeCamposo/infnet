package dataminingcluster.view;

import java.awt.Checkbox;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GuiBode
 */
public class TelaColunas extends javax.swing.JFrame {

    List<String> colunasEscolhidas = new ArrayList<String>();
    javax.swing.JFrame janelaRoot ;

    public TelaColunas(List<String> colunas ,javax.swing.JFrame root  ) {
       
        janelaRoot = root;        
        geraChecks(colunas);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jbOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleção de colunas");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jbOk.setText("ok");
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        getContentPane().add(jbOk, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        verificaChecks();
        
        ((TelaPrincipal)janelaRoot).atualizaColunasSelecao(colunasEscolhidas);
        
        this.dispose();
    }//GEN-LAST:event_jbOkActionPerformed

    private void geraChecks(List<String> colunas) {

        for (String coluna : colunas) {

            Checkbox check = new Checkbox(coluna);

            java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();


            getContentPane().add(check);


        }



        repaint();

    }

    
    /**
     * verifica as checks marcadas para adicionar a lista de colunas de parametro
     */
    private void verificaChecks() {

        Component[] componentes = getContentPane().getComponents();


        for (Component component : componentes) {

            if (component instanceof Checkbox) {

                Checkbox check = (Checkbox) component;

                if (check.getState()) {

                    colunasEscolhidas.add(check.getLabel());
                }

            }
        }




    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbOk;
    // End of variables declaration//GEN-END:variables
}
