package com.ativa.daos;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import com.ativa.entidades.Funcionario;
import com.ativa.entidades.Proposta;
import com.ativa.entidades.PropostaWorkflow;
import com.ativa.entidades.StatusAtiva;

public class WorkFlowDao {

	
	private static WorkFlowDao instance;

	private HashSet<PropostaWorkflow> mock = new HashSet<PropostaWorkflow>();
	
	public static WorkFlowDao getInstance() {
		if (instance == null) {
			instance = new WorkFlowDao();
		}
		return instance;
	}
	
	private WorkFlowDao(){}
	
	public void salvarAlteracao(Proposta proposta, Funcionario funcionario, StatusAtiva status){
		PropostaWorkflow prop = new  PropostaWorkflow();
		prop.setData(new Timestamp(new Date().getTime()) );
		prop.setFuncionario(funcionario);
		prop.setStatus(status);
		
		mock.add(prop);
	}
	
	
}
