package com.aytocartagena.controller.dto;

import java.util.Date;

import com.aytocartagena.controller.view.Tipificable;
import com.aytocartagena.model.medidas.MedidaMota;
import com.aytocartagena.model.medidas.MedidaMotaAguaBasica;
import com.aytocartagena.model.medidas.MedidaMotaContaminacionBasica;
import com.aytocartagena.model.medidas.MedidaMotaGps;
import com.aytocartagena.model.medidas.MedidaMotaParking;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.model.motas.MotaAguaBasica;
import com.aytocartagena.model.motas.MotaContaminacionBasica;
import com.aytocartagena.model.motas.MotaGps;
import com.aytocartagena.model.motas.MotaParking;
import com.aytocartagena.model.sensores.SensorCalidadAgua;
import com.aytocartagena.model.sensores.SensorContaminacionBasico;
import com.aytocartagena.model.sensores.SensorGps;
import com.aytocartagena.model.sensores.SensorParking;
import com.aytocartagena.model.sensores.SensorTemperatura;
import com.aytocartagena.util.Constantes;
import com.aytocartagena.util.UtilesVista;

public class MedidaMotaDto implements Tipificable{
	private String tipo;
	private Integer idMota;
	private Integer idMedida;
	private Date fechaMedida;
	private SensorCalidadAgua sensorCalidadAgua;
	private SensorGps sensorGps;
	private SensorContaminacionBasico sensorContaminacionBasico;
	private SensorTemperatura sensorTemperatura;
	private SensorParking sensorParking;
	private String textoMedidaHtml;
	
	public MedidaMotaDto() {
		super();
		inicializar();
	}
	private void inicializar() {
		idMedida=0;
		idMota=0;
		fechaMedida=new Date();
		sensorCalidadAgua= new SensorCalidadAgua();
		sensorGps= new SensorGps();
		sensorContaminacionBasico= new SensorContaminacionBasico();
		sensorTemperatura= new SensorTemperatura();
		sensorParking= new SensorParking();
	}
	
	
	public MedidaMotaDto(MedidaMota medidaMota) {
		super();
		inicializar();
		medidaMota.setPropiedadesDto(this);
	}
	/**
	 * Construye una MedidaMota del tipo indicado en TipoMota.
	 *
	 * @return the mota
	 */
	public MedidaMota buildMedidaMota(Mota mota) {
		MedidaMota medidaMota=null;
		switch (mota.getTipo()) {
        case Constantes.TiposMota.AGUA_BASICA:medidaMota= new MedidaMotaAguaBasica((MotaAguaBasica)mota);break;
        case Constantes.TiposMota.CONTAMINACION_BASICA: medidaMota= new MedidaMotaContaminacionBasica((MotaContaminacionBasica)mota);break;
        case Constantes.TiposMota.GPS: medidaMota= new MedidaMotaGps((MotaGps)mota);break;
        case Constantes.TiposMota.PARKING: medidaMota= new MedidaMotaParking((MotaParking)mota);break;
		}
		if (medidaMota!=null) {
			medidaMota.setPropiedadesMedidaMota(this);
			return medidaMota;
		}
		return null;
	}
	@Override
	public String getTipoCss() {
		return UtilesVista.getTipoCss(tipo);
	}
	@Override
	public String getTipoCssGrande() {
		return UtilesVista.getTipoCssGrande(tipo);
	}
	
	public Integer getIdMedida() {
		return idMedida;
	}
	public void setIdMedida(Integer idMedida) {
		this.idMedida = idMedida;
	}
	public Date getFechaMedida() {
		return fechaMedida;
	}
	public void setFechaMedida(Date fechaMedida) {
		this.fechaMedida = fechaMedida;
	}
	public SensorCalidadAgua getSensorCalidadAgua() {
		return sensorCalidadAgua;
	}
	public void setSensorCalidadAgua(SensorCalidadAgua sensorCalidadAgua) {
		this.sensorCalidadAgua = sensorCalidadAgua;
	}
	public SensorGps getSensorGps() {
		return sensorGps;
	}
	public void setSensorGps(SensorGps sensorGps) {
		this.sensorGps = sensorGps;
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
	public SensorParking getSensorParking() {
		return sensorParking;
	}
	public void setSensorParking(SensorParking sensorParking) {
		this.sensorParking = sensorParking;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public String getTextoMedidaHtml() {
		return textoMedidaHtml;
	}
	public void setTextoMedidaHtml(String textoMedidaHtml) {
		this.textoMedidaHtml = textoMedidaHtml;
	}

	public Integer getIdMota() {
		return idMota;
	}
	public void setIdMota(Integer idMota) {
		this.idMota = idMota;
	}
	
	
}
