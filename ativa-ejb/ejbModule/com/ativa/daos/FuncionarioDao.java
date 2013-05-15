package com.ativa.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ativa.entidades.Funcionario;
import com.ativa.util.HibernateUtils;

public class FuncionarioDao extends DefaultDao {
	
Session session;
	 
	@SuppressWarnings("unchecked")
	public Funcionario buscarFuncionario(String login, String senha) throws Exception {

		 session = HibernateUtils.getInstance().getSession();

		try {
			List<Funcionario> lst = null;
			Criteria criteria = session.createCriteria(Funcionario.class).add(Restrictions.like("login", login)).add(Restrictions.like("senha", senha));

			lst = criteria.list();
			session.close();

			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}

			return null;
		} catch (HibernateException e) {
			session.close();
			throw e;
		}
	}

}
