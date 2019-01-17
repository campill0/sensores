package com.aytocartagena.model.medidas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MedidaMotaDto;
import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.MotaAguaBasica;
import com.aytocartagena.model.motas.MotaPosicionada;
import com.aytocartagena.model.sensores.SensorCalidadAgua;
import com.aytocartagena.model.sensores.SensorGps;
import com.aytocartagena.util.Constantes;
import com.aytocartagena.util.UtilesVista;
@Entity
@DiscriminatorValue(value=Constantes.TiposMota.AGUA_BASICA)
public class MedidaMotaAguaBasica extends MedidaMotaPosicionada{
	@Embedded
	private SensorCalidadAgua sensorCalidadAgua;

	
	public MedidaMotaAguaBasica() {
		super();
	}

	public MedidaMotaAguaBasica(MotaPosicionada motaPosicionada) {
		super(motaPosicionada);
	}

	public MedidaMotaAguaBasica(MotaAguaBasica mota) {
		super(mota);
		sensorCalidadAgua= new SensorCalidadAgua();
	}
	
	@Override
	public String getTipo() {
		return Constantes.TiposMota.AGUA_BASICA;
	}
	
	
	@Override
	public void setPropiedadesDto(MedidaMotaDto dto) {
		super.setPropiedadesDto(dto);
		dto.setTipo(getTipo());
		dto.getSensorCalidadAgua().setConductividad(sensorCalidadAgua.getConductividad());
		dto.getSensorCalidadAgua().setOrp(sensorCalidadAgua.getOrp());
		dto.getSensorCalidadAgua().setPh(sensorCalidadAgua.getPh());
		dto.getSensorCalidadAgua().setTemperaturaAgua(sensorCalidadAgua.getTemperaturaAgua());
		dto.getSensorCalidadAgua().setTurbidez(sensorCalidadAgua.getTurbidez());
	}
	@Override
	public  void setPropiedadesMedidaMota(MedidaMotaDto dto) {
		super.setPropiedadesMedidaMota(dto);
		getSensorCalidadAgua().setConductividad(dto.getSensorCalidadAgua().getConductividad());
		getSensorCalidadAgua().setOrp(dto.getSensorCalidadAgua().getOrp());
		getSensorCalidadAgua().setPh(dto.getSensorCalidadAgua().getPh());
		getSensorCalidadAgua().setTemperaturaAgua(getSensorCalidadAgua().getTemperaturaAgua());
		getSensorCalidadAgua().setTurbidez(getSensorCalidadAgua().getTurbidez());
	}
	
	@Override
	public String getTextoHtml() {
		return super.getTextoHtml()+getSensorCalidadAgua().getTextoHtml();
	}
	
	
	@Override
	public String toString() {
		return super.toString()+"MedidaMotaAguaBasica [sensorCalidadAgua=" + sensorCalidadAgua +"]";
	}
	public SensorCalidadAgua getSensorCalidadAgua() {
		return sensorCalidadAgua;
	}
	public void setSensorCalidadAgua(SensorCalidadAgua sensorCalidadAgua) {
		this.sensorCalidadAgua = sensorCalidadAgua;
	}
	
	
}