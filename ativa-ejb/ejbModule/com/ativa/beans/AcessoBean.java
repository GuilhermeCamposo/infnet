package com.ativa.beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ativa.daos.FuncionarioDao;
import com.ativa.entidades.Funcionario;
import com.ativa.interfaces.IAcesso;

@Stateless
@Remote(IAcesso.class)
public class AcessoBean implements IAcesso {

	@Override
	public Funcionario logarFuncionario(String senha, String login) {
		
	Funcionario funcionario= null;
	try {
		funcionario = new FuncionarioDao().buscarFuncionario(login, senha);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return funcionario;
	}

}
