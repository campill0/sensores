package com.aytocartagena.model.sensores;

import java.util.Arrays;

import javax.persistence.Embedded;

import com.aytocartagena.model.Posicion;
import com.aytocartagena.util.UtilesVista;

public class SensorGps  extends Sensor{
	@Embedded
	private Posicion posicion;

	public SensorGps() {
		super();
		posicion= new Posicion();
	}
	
	@Override
	public String getTextoHtml() {
		
		return 	UtilesVista.infoSensor("Sensor gps",
				Arrays.asList(
						new UtilesVista.Propiedad("Latitud:",posicion.getLatitud()+""),
						new UtilesVista.Propiedad("Longitud:",posicion.getLongitud()+""),
						new UtilesVista.Propiedad("Altitud:",posicion.getAltitud()+"")
						));
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}
