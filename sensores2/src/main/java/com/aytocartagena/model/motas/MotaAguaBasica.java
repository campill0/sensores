package com.aytocartagena.model.motas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.util.Constantes;

@Entity
@DiscriminatorValue(value=Constantes.TiposMota.AGUA_BASICA)
public  class MotaAguaBasica extends MotaPosicionada{
	
	/**  Lugar. Cadena de texto que identifica donde se encuentra el agua analizada. Puede ser un río,rambla,pantano,playa,etc... */
	private String lugar;
	
	@Override
	public String getTipo() {
		return Constantes.TiposMota.AGUA_BASICA;
	}

	@Override
	public void setPropiedadesDto(MotaDto dto) {
		super.setPropiedadesDto(dto);
		setPropiedadesMotaAguaBasicaDto(dto);
	}
	@Override
	public void setPropiedadesMota(MotaDto dto) {
		super.setPropiedadesMota(dto);
		this.lugar=dto.getLugar();
	}
	private void setPropiedadesMotaAguaBasicaDto(MotaDto dto) {
		dto.setLugar(this.lugar);
		dto.setTipoMota(getTipo());
	}


	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString() {
		return super.toString()+"MotaAguaBasica [lugar=" + lugar + "]";
	}
	


	

	
}
