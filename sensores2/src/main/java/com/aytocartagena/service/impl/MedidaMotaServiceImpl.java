package com.aytocartagena.service.impl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aytocartagena.dao.GenericDao;
import com.aytocartagena.dao.MedidaMotaDao;
import com.aytocartagena.model.medidas.MedidaMota;
import com.aytocartagena.model.medidas.MedidaMotaContaminacionBasica;
import com.aytocartagena.service.MedidaMotaService;
import com.aytocartagena.util.Constantes;

@Service
public class MedidaMotaServiceImpl extends GenericServiceImpl<MedidaMota, Integer>
        implements MedidaMotaService {

	  	private MedidaMotaDao medidaMotaDao;
	    public MedidaMotaServiceImpl(){

	    }
	    @Autowired
	    public MedidaMotaServiceImpl(
	            @Qualifier("medidaMotaDaoImpl") GenericDao<MedidaMota, Integer> genericDao) {
	        super(genericDao);
	        this.medidaMotaDao = (MedidaMotaDao) genericDao;
	    }
	    
		@Override
		public List<MedidaMota> getMedidasMotaByFechaYTipo(String desde, String hasta, String tipo) {
			return medidaMotaDao.getMedidasMotaByFechaYTipo(desde, hasta, tipo);
		}
		
	
}
