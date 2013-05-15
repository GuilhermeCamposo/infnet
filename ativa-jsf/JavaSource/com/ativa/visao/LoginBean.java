package com.ativa.visao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ativa.entidades.Funcionario;
import com.ativa.interfaces.IAcesso;

@ManagedBean
public class LoginBean {

	private String senha, nome;

	@EJB
	private IAcesso acessoBean;

	public String logar() {

		Funcionario funcionario = acessoBean.logarFuncionario(senha, nome);

		if (funcionario != null)
			return "pagina";

		return "";
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
