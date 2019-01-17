package com.aytocartagena.model.motas;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.Posicion;

@Entity
public abstract class MotaPosicionada extends Mota{
	@Embedded
	private Posicion posicion;

	
	public MotaPosicionada() {
		super();
		posicion=new Posicion();
	}
	
	@Override
	public void setPropiedadesDto(MotaDto dto) {
		super.setPropiedadesDto(dto);
		dto.setPosicion(new Posicion(posicion.getLatitud(),posicion.getLongitud(),posicion.getAltitud()));

		
	}
	@Override
	public  void setPropiedadesMota(MotaDto dto) {
		super.setPropiedadesMota(dto);
		posicion=new Posicion(dto.getPosicion().getLatitud(),dto.getPosicion().getLongitud(),dto.getPosicion().getAltitud());

	}
	

	
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return super.toString()+"MotaPosicionada [posicion=" + posicion + "]";
	}
	
	
}
