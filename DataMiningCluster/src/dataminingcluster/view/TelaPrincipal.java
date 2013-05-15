package dataminingcluster.view;

import dataminingcluster.control.Clusterizador;
import dataminingcluster.model.Conexao;
import dataminingcluster.model.Dao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author GuiBode
 */
public class TelaPrincipal extends javax.swing.JFrame {

    Dao dao;
    String[] colunas;
    Conexao conexao;
    String[][] centroides;

    /** Creates new form TelaPrincipal */
    public TelaPrincipal() {

        initComponents();
        jbInserir.setEnabled(false);

        if (conexao != null) {
            inicializaComponentes();
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtaSaidaTexto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jcbTabela = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jtfParametros = new javax.swing.JTextField();
        jpCentroide = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfNumCentroide = new javax.swing.JTextField();
        jtfValorCentroide = new javax.swing.JTextField();
        jbInserir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaCentroides = new javax.swing.JTextArea();
        jbLimpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfCriterioParada = new javax.swing.JTextField();
        jbComecar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Mining - Cluster");

        jtaSaidaTexto.setColumns(20);
        jtaSaidaTexto.setRows(5);
        jtaSaidaTexto.setFocusable(false);
        jScrollPane1.setViewportView(jtaSaidaTexto);

        jLabel1.setText("Tabela :");

        jLabel2.setText("Parâmetro :");

        jtfParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfParametrosActionPerformed(evt);
            }
        });
        jtfParametros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfParametrosFocusGained(evt);
            }
        });

        jpCentroide.setBorder(javax.swing.BorderFactory.createTitledBorder("Centróide"));

        jLabel3.setText("número :");

        jbInserir.setText("Inserir");
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jtaCentroides.setColumns(20);
        jtaCentroides.setRows(5);
        jtaCentroides.setFocusable(false);
        jScrollPane2.setViewportView(jtaCentroides);

        jbLimpar.setText("limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCentroideLayout = new javax.swing.GroupLayout(jpCentroide);
        jpCentroide.setLayout(jpCentroideLayout);
        jpCentroideLayout.setHorizontalGroup(
            jpCentroideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCentroideLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpCentroideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCentroideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfValorCentroide, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpCentroideLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfNumCentroide)))
                    .addGroup(jpCentroideLayout.createSequentialGroup()
                        .addComponent(jbInserir)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpCentroideLayout.setVerticalGroup(
            jpCentroideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCentroideLayout.createSequentialGroup()
                .addGroup(jpCentroideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCentroideLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jpCentroideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtfNumCentroide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jtfValorCentroide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpCentroideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbInserir)
                            .addComponent(jbLimpar)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setText("Critério de parada :");

        jbComecar.setText("Começar");
        jbComecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComecarActionPerformed(evt);
            }
        });

        jMenu1.setText("configurações");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jcbTabela, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbComecar)
                            .addComponent(jtfCriterioParada, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpCentroide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcbTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jpCentroide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfCriterioParada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jbComecar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbComecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComecarActionPerformed


        //String[][] centroides = {{"1500", "20"}, {"2000", "40"}};	


        Clusterizador clusterizador = new Clusterizador(colunas, (String) jcbTabela.getSelectedItem(), dao);

        exibiTexto(clusterizador.clusteriza(centroides, Integer.parseInt(jtfCriterioParada.getText())));

    }//GEN-LAST:event_jbComecarActionPerformed

    private void jtfParametrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfParametrosFocusGained
    }//GEN-LAST:event_jtfParametrosFocusGained

    private void jtfParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfParametrosActionPerformed
        try {
            new TelaColunas(dao.buscaColunasTabela((String) jcbTabela.getSelectedItem()), this).setVisible(true);

        } catch (Exception ex) {
            System.err.print("erro na busca das colunas");
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfParametrosActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new TelaConfiguracao(this).setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed

        int numCentroides = Integer.parseInt(jtfNumCentroide.getText());


        if (centroides == null) {
            centroides = new String[numCentroides][colunas.length];
        }

        String entrada = jtfValorCentroide.getText();
        boolean saiLoop = false;


        if (entrada != null && !entrada.equals("")) {

            for (int i = 0; i < centroides.length; i++) {

                for (int j = 0; j < centroides[0].length; j++) {

                    if (centroides[i][j] == null) {
                        centroides[i][j] = entrada;
                        saiLoop = true;
                        break;
                    }

                }

                if (saiLoop) {
                    break;
                }

            }

        }

        imprimeCentroides();


    }//GEN-LAST:event_jbInserirActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limparCentroide();
    }//GEN-LAST:event_jbLimparActionPerformed

    /**
     * imprime os centroides escolhidos na texta area
     * @param centroide 
     */
    private void imprimeCentroides() {

        StringBuilder texto = new StringBuilder();

        for (int i = 0; i < centroides.length; i++) {

            texto.append("Centróide : ").append(i).append("\n");


            for (int j = 0; j < centroides[0].length; j++) {

                if (centroides[i][j] == null) {
                    texto.append(colunas[j]).append(" : ").append("XXXXXXXX").append("\n");
                } else {
                    texto.append(colunas[j]).append(" : ").append(centroides[i][j]).append("\n");
                }
            }

            texto.append("===================").append("\n");

        }

        jtaCentroides.setText(texto.toString());

    }

    /**
     * define os dados usados na conexão com o banco
     * @param conexao 
     */
    public void setConexao(Conexao conexao) {
        this.conexao = conexao;
        inicializaComponentes();
    }

    /**
     * limpa os campos referentes ao centroide
     */
    private void limparCentroide() {
        centroides = null;
        jtaCentroides.setText("");
        jtfNumCentroide.setText("");
        jtfValorCentroide.setText("");
    }

    private void exibiTexto(List<List<Integer>> clusters) {

        StringBuilder texto = new StringBuilder();


        int i = 1;
        for (List<Integer> grupo : clusters) {

            texto.append("Grupo : ").append(i).append("\n");
            texto.append("número de elementos : ").append(grupo.size()).append("\n");
            texto.append("========================").append("\n");
            i++;

        }

        jtaSaidaTexto.setText(texto.toString());

    }

    /**
     * atualiza quais colunas foram selecionadas
     */
    public void atualizaColunasSelecao(List<String> colunasEscolhidas) {

        colunas = new String[colunasEscolhidas.size()];
        StringBuilder texto = new StringBuilder();

        int i = 0;
        for (String coluna : colunasEscolhidas) {
            colunas[i] = coluna;
            if (i == 0) {
                texto.append(coluna);
            } else {
                texto.append(",").append(coluna);
            }

            i++;
        }

        jtfParametros.setText(texto.toString());
        jbInserir.setEnabled(true);


    }

    /**
     * inicializa a combo com as tabelas da base de dados 
     */
    private void inicializaComponentes() {

        try {
            dao = new Dao(conexao);
            jcbTabela.setModel(new DefaultComboBoxModel(dao.buscaTabelas()));
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbComecar;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JComboBox jcbTabela;
    private javax.swing.JPanel jpCentroide;
    private javax.swing.JTextArea jtaCentroides;
    private javax.swing.JTextArea jtaSaidaTexto;
    private javax.swing.JTextField jtfCriterioParada;
    private javax.swing.JTextField jtfNumCentroide;
    private javax.swing.JTextField jtfParametros;
    private javax.swing.JTextField jtfValorCentroide;
    // End of variables declaration//GEN-END:variables
}
