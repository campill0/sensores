package com.aytocartagena.model.builders;

import java.util.Date;

import com.aytocartagena.model.medidas.MedidaMotaGps;
import com.aytocartagena.model.motas.MotaGps;

public class MedidaMotaGpsBuilder {

	private MedidaMotaGps medidaMota;
	
	public MedidaMotaGpsBuilder(MotaGps motaGps) {
		super();
		medidaMota= new MedidaMotaGps(motaGps);
	}
	/** Genéricos de MedidaMota**/
	public MedidaMotaGpsBuilder setFechaMedida(Date fechaMedida) {  medidaMota.setFechaMedida(fechaMedida);  return this; 	}
	
	/** Específicos de MedidaMotaGps **/
	public MedidaMotaGpsBuilder setPosicionAltitud(float altitud) {
		medidaMota.getSensorGps().getPosicion().setAltitud(altitud);  return this; 	
		}
	public MedidaMotaGpsBuilder setPosicionLatitud(float latitud) {  medidaMota.getSensorGps().getPosicion().setLatitud(latitud);  return this; 	}
	public MedidaMotaGpsBuilder setPosicionLongitud(float longitud) {  medidaMota.getSensorGps().getPosicion().setLongitud(longitud);  return this; 	}
	
	public MedidaMotaGps build() {  return medidaMota; 	}
}
