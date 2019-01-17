package com.aytocartagena.service.impl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aytocartagena.dao.GenericDao;
import com.aytocartagena.dao.MotaDao;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.service.MotaService;

@Service
public class MotaServiceImpl extends GenericServiceImpl<Mota, Integer>
        implements MotaService {

	   private MotaDao motaDao;
	   	@Autowired
	    private SessionFactory sessionFactory;
	    public MotaServiceImpl(){

	    }
	    @Autowired
	    public MotaServiceImpl(
	            @Qualifier("motaDaoImpl") GenericDao<Mota, Integer> genericDao) {
	        super(genericDao);
	        this.motaDao = (MotaDao) genericDao;
	    }
		@Override
		public Mota getMota(Integer id) {
			return motaDao.getMota(id);
		}
		
	    
	    
}
