package com.aytocartagena.model.sensores;

import java.util.Arrays;

import org.hibernate.annotations.ColumnDefault;

import com.aytocartagena.util.UtilesVista;

public class SensorContaminacionBasico  extends Sensor{
	@ColumnDefault(value = "0")
	private float luminosidad;
	@ColumnDefault(value = "0")
	private float ruido;
	@ColumnDefault(value = "0")
	private float pm1;
	@ColumnDefault(value = "0")
	private float pm25;
	@ColumnDefault(value = "0")
	private float pm10;
	
	
	@Override
	public String getTextoHtml() {
		
		return 	UtilesVista.infoSensor("Sensor de contaminación",
				Arrays.asList(
						new UtilesVista.Propiedad("Luminosidad:",luminosidad+""),
						new UtilesVista.Propiedad("Ruido:",ruido+""),
						new UtilesVista.Propiedad("PM1:",pm1+""),
						new UtilesVista.Propiedad("PM2.5:",pm25+""),
						new UtilesVista.Propiedad("PM10:",pm10+"")
						
						));
	}

	
	
	public float getLuminosidad() {
		return luminosidad;
	}
	public void setLuminosidad(float luminosidad) {
		this.luminosidad = luminosidad;
	}
	public float getRuido() {
		return ruido;
	}
	public void setRuido(float ruido) {
		this.ruido = ruido;
	}
	public float getPm1() {
		return pm1;
	}
	public void setPm1(float pm1) {
		this.pm1 = pm1;
	}
	public float getPm25() {
		return pm25;
	}
	public void setPm25(float pm25) {
		this.pm25 = pm25;
	}
	public float getPm10() {
		return pm10;
	}
	public void setPm10(float pm10) {
		this.pm10 = pm10;
	}

	
}
