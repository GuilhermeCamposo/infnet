package com.ativa.interfaces;

import com.ativa.entidades.Funcionario;

public interface IAcesso {
	
	Funcionario logarFuncionario(String senha, String nome);

}
