package com.aytocartagena.model;

import javax.persistence.Embeddable;

@Embeddable
public class Direccion {

	private String calle;
	private String numero;
	private String codpostal;
	
	public Direccion() {
		super();
	}
	
	public Direccion(String calle, String numero, String codpostal) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.codpostal = codpostal;
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodpostal() {
		return codpostal;
	}
	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	
	
}
