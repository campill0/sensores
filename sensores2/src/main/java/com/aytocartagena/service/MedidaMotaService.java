package com.aytocartagena.service;

import java.util.List;
import java.util.Map;

import com.aytocartagena.model.medidas.MedidaMota;

public interface MedidaMotaService extends GenericService<MedidaMota,Integer>{
	public List<MedidaMota> getMedidasMotaByFechaYTipo(String desde,String hasta,String tipo);
	
}
