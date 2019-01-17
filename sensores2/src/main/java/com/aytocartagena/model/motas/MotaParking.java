package com.aytocartagena.model.motas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.Direccion;
import com.aytocartagena.util.Constantes;

@Entity
@DiscriminatorValue(value=Constantes.TiposMota.PARKING)
public  class MotaParking extends MotaPosicionada{
	
	@Embedded
	private Direccion direccion;
	
	@Override
	public String getTipo() {
		return Constantes.TiposMota.PARKING;
	}
	
	@Override
	public void setPropiedadesDto(MotaDto dto) {
		super.setPropiedadesDto(dto);
		setPropiedadesMotaAguaBasicaDto(dto);
		
	}
	
	private void setPropiedadesMotaAguaBasicaDto(MotaDto dto) {
		dto.setDireccion(new Direccion(this.direccion.getCalle(),this.direccion.getNumero(),this.direccion.getCodpostal()));
		dto.setTipoMota(getTipo());
	}
	@Override
	public void setPropiedadesMota(MotaDto dto) {
		super.setPropiedadesMota(dto);
		this.direccion= new Direccion(dto.getDireccion().getCalle(),dto.getDireccion().getNumero(),dto.getDireccion().getCodpostal());
		
	}
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return super.toString()+"MotaParking [direccion=" + direccion + "]";
	}

	

	
	
	

	
}
