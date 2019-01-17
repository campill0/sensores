package com.aytocartagena.model.sensores;

import java.util.Arrays;

import javax.persistence.Embeddable;

import org.hibernate.annotations.ColumnDefault;

import com.aytocartagena.util.UtilesVista;

@Embeddable
public class SensorCalidadAgua  extends Sensor{
	/** pH **/
	@ColumnDefault(value = "0")
	private float ph;
	/** Oxidation-Reduction Potential (ORP) **/
	@ColumnDefault(value = "0")
	private float orp;
	/** Dissolved Oxygen (DO) **/
	@ColumnDefault(value = "0")
	private float conductividad;
	/** Temperatura **/
	@ColumnDefault(value = "0")
	private float temperaturaAgua;
	/** Turbidez **/
	@ColumnDefault(value = "0")
	private float turbidez;
	
	
	@Override
	public String getTextoHtml() {
		
		return 	UtilesVista.infoSensor("Sensor de contaminación",
				Arrays.asList(
						new UtilesVista.Propiedad("Ph:",ph+""),
						new UtilesVista.Propiedad("ORP:",orp+""),
						new UtilesVista.Propiedad("Conductividad:",conductividad+""),
						new UtilesVista.Propiedad("TemperaturaAgua:",temperaturaAgua+""),
						new UtilesVista.Propiedad("Turbidez:",turbidez+"")
						
						));
	}
	

	
	
	
	
	
	public float getPh() {
		return ph;
	}
	public void setPh(float ph) {
		this.ph = ph;
	}
	public float getOrp() {
		return orp;
	}
	public void setOrp(float orp) {
		this.orp = orp;
	}
	public float getConductividad() {
		return conductividad;
	}
	public void setConductividad(float conductividad) {
		this.conductividad = conductividad;
	}
	public float getTemperaturaAgua() {
		return temperaturaAgua;
	}
	public void setTemperaturaAgua(float temperaturaAgua) {
		this.temperaturaAgua = temperaturaAgua;
	}
	public float getTurbidez() {
		return turbidez;
	}
	public void setTurbidez(float turbidez) {
		this.turbidez = turbidez;
	}
	
	

	
	
}
