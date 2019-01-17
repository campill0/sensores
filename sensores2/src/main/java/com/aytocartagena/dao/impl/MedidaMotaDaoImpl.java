package com.aytocartagena.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aytocartagena.dao.MedidaMotaDao;
import com.aytocartagena.model.medidas.MedidaMota;
@Transactional
@Repository
public class MedidaMotaDaoImpl extends GenericDaoImpl<MedidaMota, Integer> implements MedidaMotaDao {

	@Override
	public List<MedidaMota> getMedidasMotaByFechaYTipo(String desde, String hasta, String tipo) {
		List<MedidaMota> medidasMotas = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
			Date desdeDate=null;
			Date hastaDate=null;
			if (desde.length()==0) {
				desde = "1970-01-0100:00:00";
				desdeDate = format.parse(desde);
			} else {
				desdeDate = format.parse(desde);
			}
			if (hasta.length()==0) {
				hastaDate = new Date();
			} else {
				hastaDate = format.parse(hasta);
			}

			String sql = "";
			if (tipo.length()>0) {
				sql = "from MedidaMota m where type(m) = :tipo and m.fechaMedida BETWEEN :desde AND :hasta";
			} else {
				sql = "from MedidaMota m where m.fechaMedida BETWEEN :desde AND :hasta";
			}
			Query query = currentSession().createQuery(sql);
			if(tipo.length()>0) {
				Class<?> clase = Class.forName("com.aytocartagena.model.medidas."+tipo);
				query.setParameter("tipo", clase);
			}
			
			query.setTimestamp("desde", desdeDate);
			query.setTimestamp("hasta", hastaDate);
			medidasMotas = query.list();
		
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return medidasMotas;
	}
	

}