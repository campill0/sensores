package com.aytocartagena.service;

import com.aytocartagena.model.motas.Mota;

/**
 * AdminService
 */
public interface MotaService extends GenericService<Mota,Integer>{
	public Mota getMota(Integer id);
}
