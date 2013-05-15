package com.ativa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 8928095725167220505L;

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "tomador"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "cpf_tomador", unique = true, nullable = false)
	private String cpfTomador;

	private String bairro, cidade;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Tomador tomador;

	public String getCpfTomador() {
		return cpfTomador;
	}

	public void setCpfTomador(String cpfTomador) {
		this.cpfTomador = cpfTomador;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Tomador getTomador() {
		return tomador;
	}

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
	}
	
	

}
