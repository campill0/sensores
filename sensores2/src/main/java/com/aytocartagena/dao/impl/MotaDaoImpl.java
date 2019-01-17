package com.aytocartagena.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aytocartagena.dao.MotaDao;
import com.aytocartagena.model.motas.Mota;

@Repository
@Transactional
public class MotaDaoImpl extends GenericDaoImpl<Mota, Integer> implements MotaDao {


	
	@Override
	public Mota getMota(Integer id) {
		 Query query = currentSession().createQuery( "from Mota m where idMota = :id");
		
		 query.setParameter("id", id);
		 Mota mota = (Mota) query.uniqueResult();
		 Hibernate.initialize(mota.getMedidasMota());
	        return mota;
	}


   
}