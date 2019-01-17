package com.aytocartagena.model.builders;

import java.util.Date;

import com.aytocartagena.model.medidas.MedidaMotaContaminacionBasica;
import com.aytocartagena.model.motas.MotaContaminacionBasica;

public class MedidaMotaContaminacionBasicaBuilder {

	private MedidaMotaContaminacionBasica medidaMota;
	
	public MedidaMotaContaminacionBasicaBuilder(MotaContaminacionBasica mota) {
		super();
		medidaMota= new MedidaMotaContaminacionBasica(mota);
	}
	/** Genéricos de MedidaMota**/
	public MedidaMotaContaminacionBasicaBuilder setFechaMedida(Date fechaMedida) {  medidaMota.setFechaMedida(fechaMedida);  return this; 	}
	
	/** Específicos de MedidaMotaContaminacionBasica **/
	/** sensorGps **/
	public MedidaMotaContaminacionBasicaBuilder setPosicionAltitud(float altitud) {medidaMota.getSensorGps().getPosicion().setAltitud(altitud);  return this; 	}
	public MedidaMotaContaminacionBasicaBuilder setPosicionLatitud(float latitud) {  medidaMota.getSensorGps().getPosicion().setLatitud(latitud);  return this; 	}
	public MedidaMotaContaminacionBasicaBuilder setPosicionLongitud(float longitud) {  medidaMota.getSensorGps().getPosicion().setLongitud(longitud);  return this; 	}
	
	/** sensorContaminacionBasico **/
	public MedidaMotaContaminacionBasicaBuilder setLuminosidad(float luminosidad) {  medidaMota.getSensorContaminacionBasico().setLuminosidad(luminosidad);  return this; 	}
	public MedidaMotaContaminacionBasicaBuilder setRuido(float ruido) {  medidaMota.getSensorContaminacionBasico().setRuido(ruido);  return this; 	}
	public MedidaMotaContaminacionBasicaBuilder setPm1(float pm1) {  medidaMota.getSensorContaminacionBasico().setPm1(pm1);  return this; 	}
	public MedidaMotaContaminacionBasicaBuilder setPm10(float pm10) {  medidaMota.getSensorContaminacionBasico().setPm10(pm10);  return this; 	}
	public MedidaMotaContaminacionBasicaBuilder setPm25(float pm25) {  medidaMota.getSensorContaminacionBasico().setPm25(pm25);  return this; 	}
	
	/** sensorContaminacionTemperatura **/
	public MedidaMotaContaminacionBasicaBuilder setTemperatura(float temperatura) {  medidaMota.getSensorTemperatura().setTemperatura(temperatura); return this; 	}
	
	public MedidaMotaContaminacionBasica build() {  return medidaMota; 	}
}
