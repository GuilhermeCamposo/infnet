package dataminingcluster.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {


    private Connection conn = null;
    Conexao conexao ;

    public Dao(Conexao conexao) throws Exception {
        System.out.println("Registrando o driver de banco de dados");
        Class.forName("org.postgresql.Driver");
        this.conexao = conexao ;
    }



    private Statement abrirConexao() throws Exception {

        System.out.println("Abrindo conexao com o banco de dados...");

        conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/"+conexao.banco, conexao.login,
                conexao.password);
        conn.setAutoCommit(false);

        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    private void fecharConexao() throws Exception {
        System.out.println("Fechando conexao com banco de dados...");
        conn.close();
    }

    /**
     * busca todas as tabelas existentes na base da aplica��o
     * 
     * @return
     * @throws Exception
     */
    public String[] buscaTabelas() throws Exception {

        Statement stm = abrirConexao();

        ResultSet rs = stm.executeQuery("SELECT * FROM pg_catalog.pg_tables WHERE schemaname NOT IN ('pg_catalog', 'information_schema', 'pg_toast') ORDER BY schemaname, tablename");

        List<String> tabelas = new ArrayList<String>();

        while (rs.next()) {
            tabelas.add(rs.getString("tablename"));

        }

        fecharConexao();


        String[] resultado = new String[tabelas.size()];

        for (int i = 0; i < tabelas.size(); i++) {
            resultado[i] = tabelas.get(i);

        }



        return resultado;

    }

    /**
     * buscas as colunas numérica da tabela
     * 
     * @param tabela
     * @return
     * @throws Exception
     */
    public List<String> buscaColunasTabela(String tabela) throws Exception {

        Statement stm = abrirConexao();

        ResultSet rs = stm.executeQuery("SELECT attrs.attname, \"Type\" "+
"FROM ( SELECT c.oid, n.nspname, c.relname  FROM pg_catalog.pg_class   c "+
"LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace "+
"WHERE pg_catalog.pg_table_is_visible(c.oid)   ) rel "+
"JOIN ( SELECT a.attname, a.attrelid, pg_catalog.format_type(a.atttypid,   a.atttypmod) "+
"as \"Type\",  (SELECT substring(d.adsrc for 128) FROM pg_catalog.pg_attrdef   d "+
"WHERE d.adrelid = a.attrelid AND d.adnum = a.attnum AND a.atthasdef) "+
"as \"Default\",a.attnotnull, a.attnum  FROM pg_catalog.pg_attribute a WHERE a.attnum > 0   AND NOT a.attisdropped ) "+
"attrs   ON (attrs.attrelid = rel.oid )  WHERE relname = '"+tabela+"' ORDER BY attrs.attnum;");

        List<String> colunas = new ArrayList<String>();

        while (rs.next()) {
            if (rs.getString("Type").equals("real" )|| rs.getString("Type").equals("integer" ) ) {
                colunas.add(rs.getString("attname"));
            }
             

        }

        return colunas;
    }

    public String[][] leTabela(String[] colunas, String tabela)
            throws Exception {

        Statement stm = abrirConexao();

        ResultSet rs = stm.executeQuery(montaSelect(colunas, tabela));

        rs.last();

        String[][] dados = new String[rs.getRow()][colunas.length];

        rs.beforeFirst();

        int linha = 0;

        while (rs.next()) {

            for (int i = 0; i < colunas.length; i++) {

                dados[linha][i] = rs.getString(i + 1);

            }

            linha++;

        }

        fecharConexao();

        return dados;

    }

    /**
     * monta uma busca simples  na tabela passada pelo par�metro , buscando de acordo com as colunas tb passadas
     * @param colunas
     * @param tabela
     * @return
     */
    private String montaSelect(String[] colunas, String tabela) {

        StringBuilder sql = new StringBuilder();

        sql.append("select ");

        for (int i = 0; i < colunas.length; i++) {

            if (i == 0) {
                sql.append(colunas[i]);
            } else {
                sql.append(",").append(colunas[i]);
            }

        }

        sql.append(" from ").append(tabela);

        return sql.toString();
    }
}
