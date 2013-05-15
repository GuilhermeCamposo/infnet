package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Pessoa implements Serializable{

	private int id;
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private double salario;
	private Set<Endereco> enderecos = new HashSet<Endereco>();


	public Pessoa() {
		// TODO Auto-generated constructor stub
	}


	public Pessoa(String nome, Date dataNascimento, String sexo, double salario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.salario = salario;
	}
	
	
	
	
	
	public Set getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	public void adicionar (Endereco e){
		this.enderecos.add(e);
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}



	@Override
	public String toString() {
		
		
		StringBuffer saida = new StringBuffer();
		
		saida.append("Pessoa [id=" + id + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento + ", sexo=" + sexo + ", salario=" + salario
				+ "]");
		
	 
			
		for (Iterator iterator = enderecos.iterator(); iterator.hasNext();) 
		{
			Endereco e = (Endereco) iterator.next();
			saida.append("\n" + e.toString());
		}
		
		return saida.toString();
		
	}



	
}
