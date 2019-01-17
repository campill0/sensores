package com.aytocartagena.model;

import javax.persistence.Embeddable;

import org.hibernate.annotations.ColumnDefault;

@Embeddable
public class Posicion {
	public Posicion(float latitud, float longitud, float altitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
	}
	public Posicion() {
		super();
	}
	
	@ColumnDefault(value = "0")
	private float latitud;
	@ColumnDefault(value = "0")
	private float longitud;
	@ColumnDefault(value = "0")
	private float altitud;
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public float getAltitud() {
		return altitud;
	}
	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}
	
	
	
	
}
