package com.aytocartagena.model.medidas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MedidaMotaDto;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.MotaParking;
import com.aytocartagena.model.motas.MotaPosicionada;
import com.aytocartagena.model.sensores.SensorParking;
import com.aytocartagena.util.Constantes;
import com.aytocartagena.util.UtilesVista;
@Entity
@DiscriminatorValue(value=Constantes.TiposMota.PARKING)
public class MedidaMotaParking extends MedidaMotaPosicionada{
	@Embedded
	private SensorParking sensorParking;

	
	
	public MedidaMotaParking() {
		super();
	}

	public MedidaMotaParking(MotaPosicionada motaPosicionada) {
		super(motaPosicionada);
	}

	public MedidaMotaParking(MotaParking motaParking) {
		super(motaParking);
		sensorParking= new SensorParking();
	}
	
	@Override
	public String getTipo() {
		return Constantes.TiposMota.PARKING;
	}
	
	@Override
	public void setPropiedadesDto(MedidaMotaDto dto) {
		super.setPropiedadesDto(dto);
		dto.getSensorParking().setOcupado(sensorParking.isOcupado());
		dto.setTipo(getTipo());
	}
	
	@Override
	public  void setPropiedadesMedidaMota(MedidaMotaDto dto) {
		super.setPropiedadesMedidaMota(dto);
		getSensorParking().setOcupado(dto.getSensorParking().isOcupado());
	}
	

	@Override
	public String toString() {
		return super.toString()+"MedidaMotaParking [sensorParking=" + sensorParking + "]";
	}

	@Override
	public String getTextoHtml() {
		return super.getTextoHtml()+sensorParking.getTextoHtml();
	}

	public SensorParking getSensorParking() {
		return sensorParking;
	}

	public void setSensorParking(SensorParking sensorParking) {
		this.sensorParking = sensorParking;
	}

	
	
	
}
