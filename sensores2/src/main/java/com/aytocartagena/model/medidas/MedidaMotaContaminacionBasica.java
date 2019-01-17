package com.aytocartagena.model.medidas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MedidaMotaDto;
import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.MotaContaminacionBasica;
import com.aytocartagena.model.sensores.SensorContaminacionBasico;
import com.aytocartagena.model.sensores.SensorGps;
import com.aytocartagena.model.sensores.SensorTemperatura;
import com.aytocartagena.util.Constantes;

@Entity
@DiscriminatorValue(value=Constantes.TiposMota.CONTAMINACION_BASICA)
public class MedidaMotaContaminacionBasica extends MedidaMotaPosicionada{
	@Embedded
	private SensorContaminacionBasico sensorContaminacionBasico;
	@Embedded
	private SensorTemperatura sensorTemperatura;
	
	
	public MedidaMotaContaminacionBasica() {
		super();
	}

	public MedidaMotaContaminacionBasica(MotaContaminacionBasica mota) {
		super(mota);
		sensorContaminacionBasico= new SensorContaminacionBasico();
		sensorTemperatura = new SensorTemperatura();
	}
	
	@Override
	public String getTipo() {
		return Constantes.TiposMota.CONTAMINACION_BASICA;
	}
	
	
	@Override
	public void setPropiedadesDto(MedidaMotaDto dto) {
		super.setPropiedadesDto(dto);
		dto.setTipo(getTipo());
		dto.getSensorContaminacionBasico().setLuminosidad(sensorContaminacionBasico.getLuminosidad());
		dto.getSensorContaminacionBasico().setPm1(sensorContaminacionBasico.getPm1());
		dto.getSensorContaminacionBasico().setPm10(sensorContaminacionBasico.getPm10());
		dto.getSensorContaminacionBasico().setPm25(sensorContaminacionBasico.getPm25());
		dto.getSensorContaminacionBasico().setRuido(sensorContaminacionBasico.getRuido());
		dto.getSensorTemperatura().setTemperatura(sensorTemperatura.getTemperatura());
	}
	@Override
	public  void setPropiedadesMedidaMota(MedidaMotaDto dto) {
		super.setPropiedadesMedidaMota(dto);
		getSensorContaminacionBasico().setLuminosidad(dto.getSensorContaminacionBasico().getLuminosidad());
		getSensorContaminacionBasico().setPm1(dto.getSensorContaminacionBasico().getPm1());
		getSensorContaminacionBasico().setPm10(dto.getSensorContaminacionBasico().getPm10());
		getSensorContaminacionBasico().setPm25(dto.getSensorContaminacionBasico().getPm25());
		getSensorContaminacionBasico().setRuido(dto.getSensorContaminacionBasico().getRuido());
		getSensorTemperatura().setTemperatura(dto.getSensorTemperatura().getTemperatura());
	}
	
	@Override
	public String getTextoHtml() {
		return super.getTextoHtml()+getSensorContaminacionBasico().getTextoHtml()+getSensorTemperatura().getTextoHtml();
	}

	public SensorContaminacionBasico getSensorContaminacionBasico() {
		return sensorContaminacionBasico;
	}
	public void setSensorContaminacionBasico(SensorContaminacionBasico sensorContaminacionBasico) {
		this.sensorContaminacionBasico = sensorContaminacionBasico;
	}
	public SensorTemperatura getSensorTemperatura() {
		return sensorTemperatura;
	}
	public void setSensorTemperatura(SensorTemperatura sensorTemperatura) {
		this.sensorTemperatura = sensorTemperatura;
	}
	
	public float getTemperatura() {
		return getSensorTemperatura().getTemperatura();
	}

	@Override
	public String toString() {
		return super.toString()+"MedidaMotaContaminacionBasica [sensorContaminacionBasico=" + sensorContaminacionBasico
				+ ", sensorTemperatura=" + sensorTemperatura + "]";
	}

	
}
