package com.aytocartagena.model.builders;

import java.util.Date;

import com.aytocartagena.model.medidas.MedidaMotaGps;
import com.aytocartagena.model.medidas.MedidaMotaParking;
import com.aytocartagena.model.motas.MotaGps;
import com.aytocartagena.model.motas.MotaParking;

public class MedidaMotaParkingBuilder {

	private MedidaMotaParking medidaMota;
	
	public MedidaMotaParkingBuilder(MotaParking mota) {
		super();
		medidaMota= new MedidaMotaParking(mota);
	}
	/** Genéricos de MedidaMota**/
	public MedidaMotaParkingBuilder setFechaMedida(Date fechaMedida) {  medidaMota.setFechaMedida(fechaMedida);  return this; 	}
	
	/** Genéricos de MedidaMotaPosicionada**/
	/** La posición gps no se establece ya que se coge de la que tiene configurada la Mota **/
	
	/** Específicos de MedidaParking **/
	public MedidaMotaParkingBuilder setOcupado(boolean ocupado) {medidaMota.getSensorParking().setOcupado(ocupado); return this;	}

	
	public MedidaMotaParking build() {  return medidaMota; 	}
}
