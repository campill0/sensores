
package com.aytocartagena.model.builders;

import java.util.Date;

import com.aytocartagena.model.medidas.MedidaMotaAguaBasica;
import com.aytocartagena.model.motas.MotaAguaBasica;

public class MedidaMotaAguaBasicaBuilder {

	private MedidaMotaAguaBasica mota;
	
	public MedidaMotaAguaBasicaBuilder(MotaAguaBasica motaAguaBasica) {
		super();
		mota= new MedidaMotaAguaBasica(motaAguaBasica);
	}

	/** Genéricos de MedidaMota**/
	public MedidaMotaAguaBasicaBuilder setFechaMedida(Date fechaMedida) {  mota.setFechaMedida(fechaMedida);  return this; 	}

	/** Específicos de MedidaMotaAguaBasica**/
	/** sensorGps **/
	public MedidaMotaAguaBasicaBuilder setPosicionAltitud(float altitud) {  mota.getSensorGps().getPosicion().setAltitud(altitud);  return this; 	}
	public MedidaMotaAguaBasicaBuilder setPosicionLatitud(float latitud) {  mota.getSensorGps().getPosicion().setLatitud(latitud);  return this; 	}
	public MedidaMotaAguaBasicaBuilder setPosicionLongitud(float longitud) {  mota.getSensorGps().getPosicion().setLongitud(longitud);  return this; 	}
	
	/** sensorCalidadAgua **/
	public MedidaMotaAguaBasicaBuilder setPh(float ph) {  mota.getSensorCalidadAgua().setPh(ph);  return this; 	}
	public MedidaMotaAguaBasicaBuilder setOrp(float orp) {  mota.getSensorCalidadAgua().setOrp(orp);  return this; 	}
	public MedidaMotaAguaBasicaBuilder setConductividad(float conductividad) {  mota.getSensorCalidadAgua().setConductividad(conductividad);  return this; 	}
	public MedidaMotaAguaBasicaBuilder setTemperaturaAgua(float temperaturaAgua) {  mota.getSensorCalidadAgua().setTemperaturaAgua(temperaturaAgua);  return this; 	}
	public MedidaMotaAguaBasicaBuilder setTurbidez(float turbidez) {  mota.getSensorCalidadAgua().setTurbidez(turbidez);  return this; 	}
	
	public MedidaMotaAguaBasica build() {  return mota; 	}
}
