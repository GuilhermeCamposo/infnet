package com.ativa.util;

import com.ativa.daos.FuncionarioDao;
import com.ativa.entidades.Supervisor;

public class Mock {

	public Mock() {

		Supervisor funcionario = new Supervisor();
		
		funcionario.setNome("Jose");
		funcionario.setLogin("jose");
		funcionario.setSenha("teste");
		funcionario.setDivisao("setor B");
		
		new FuncionarioDao().salvar(funcionario);
		
	}

}
