package com.aytocartagena.model.medidas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MedidaMotaDto;
import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.model.motas.MotaGps;
import com.aytocartagena.model.sensores.SensorGps;
import com.aytocartagena.util.Constantes;

@Entity
@DiscriminatorValue(value=Constantes.TiposMota.GPS)
public class MedidaMotaGps extends MedidaMota{
	
	public MedidaMotaGps() {
		super();
	}

	public MedidaMotaGps(Mota mota) {
		super(mota);
	}

	public MedidaMotaGps(MotaGps motaGps) {
		super(motaGps);
	}

	@Override
	public String getTipo() {
		return Constantes.TiposMota.GPS;
	}
	
	@Override
	public void setPropiedadesDto(MedidaMotaDto dto) {
		super.setPropiedadesDto(dto);
		dto.setTipo(getTipo());
	}

	@Override
	public String getTextoHtml() {
		return super.getTextoHtml();
	}
	
}
