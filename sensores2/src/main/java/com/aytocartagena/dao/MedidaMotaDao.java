package com.aytocartagena.dao;

import java.util.List;

import com.aytocartagena.model.medidas.MedidaMota;

/**
 * Admin Dao interface
 */
public interface MedidaMotaDao extends GenericDao<MedidaMota, Integer>{
	
	public List<MedidaMota> getMedidasMotaByFechaYTipo(String desde,String hasta,String tipo);
    
}
