package com.aytocartagena.dao;

import com.aytocartagena.model.motas.Mota;

/**
 * Mota Dao interface.
 */
public interface MotaDao extends GenericDao<Mota, Integer>{
	
	/**
	 * Obtiene una mota dado el id
	 * Este método es similar al método del DAO genérico get(Integer id) 
	 * salvo que éste carga también las MedidaMota de la mota.
	 * @param id el id de la mota
	 * @return la mota
	 */
	public Mota getMota(Integer id);
    
}
