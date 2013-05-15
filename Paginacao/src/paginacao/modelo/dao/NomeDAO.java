package paginacao.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import paginacao.modelo.entidade.Nome;

public class NomeDAO {

	private static NomeDAO dao = null;
	private Connection conn = null;
	
	private NomeDAO() throws Exception {
		System.out.println("Registrando o driver de banco de dados");
		Class.forName("org.postgresql.Driver");
	}
	
	public static NomeDAO getInstance() throws Exception {
		System.out.println("Retornando uma instancia existente ...");
		if(dao==null) dao = new NomeDAO();
		return dao;
	}
	
	private Statement abrirConexao() throws Exception {
		System.out.println("Abrindo conexao com o banco de dados...");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "guilherme");
		conn.setAutoCommit(false);
		return conn.createStatement();
	}
	
	private void fecharConexao() throws Exception {
		System.out.println("Fechando conexao com banco de dados...");
		conn.close();
	}
	
	public List<Nome> listar() throws Exception {
		Statement stm = abrirConexao();
		
		ResultSet rs = stm.executeQuery("select * from paginacao");
		List<Nome> lista = new ArrayList<Nome>();
		while(rs.next()){
			Nome contatoDO = new Nome();
			contatoDO.setId(rs.getInt("id"));
			contatoDO.setNome(rs.getString("nome"));			
			lista.add(contatoDO);
		}
		
		System.out.println("Foram encontrados " + lista.size() + " registros");
		
		fecharConexao();
		return lista;
	}
	
	public void incluir(Nome contatoDO) throws Exception {
		Statement stm = abrirConexao();
		stm.executeUpdate("insert into paginacao(nome) values ('" +
				contatoDO.getNome() +"' )" );
		conn.commit();
		fecharConexao();
	}
	
	
	
	
}
