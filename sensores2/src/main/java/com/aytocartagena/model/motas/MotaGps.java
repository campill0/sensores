package com.aytocartagena.model.motas;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.util.Constantes;

@Entity
@DiscriminatorValue(value=Constantes.TiposMota.GPS)
public  class MotaGps extends Mota{
	
	@Override
	public String getTipo() {
		return Constantes.TiposMota.GPS;
	}
	
	
	@Override
	public void setPropiedadesDto(MotaDto dto) {
		super.setPropiedadesDto(dto);
		dto.setTipoMota(getTipo());
	}

	@Override
	public void setPropiedadesMota(MotaDto dto) {
		super.setPropiedadesMota(dto);
	}

	
	

}
