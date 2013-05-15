package com.ativa.daos;

import org.hibernate.Session;

import com.ativa.util.HibernateUtils;

public class DefaultDao {

	public void salvar(Object object) {

		Session sessao = HibernateUtils.getInstance().getSession();
		sessao.beginTransaction();

		sessao.save(object);

		sessao.getTransaction().commit();

		sessao.close();
	}

}
