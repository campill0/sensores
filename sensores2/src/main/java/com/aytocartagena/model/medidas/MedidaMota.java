package com.aytocartagena.model.medidas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aytocartagena.controller.dto.MedidaMotaDto;
import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.model.sensores.SensorGps;
import com.aytocartagena.util.Constantes;
import com.aytocartagena.util.UtilesVista;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
@Entity
@Table(name = Constantes.PREFIJO_TABLAS + "medida_mota")
@DiscriminatorColumn(name="tipo")
@Inheritance(strategy = javax.persistence.InheritanceType.SINGLE_TABLE)
public abstract class MedidaMota {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "medida_mota_id")
	private Integer idMedida;
	private Date fechaMedida;
	@Embedded
	private SensorGps sensorGps;
	
	@ManyToOne
	  @JoinColumn(name = "mota_id")
	private Mota mota;
	@Transient
	private Integer idMota;
	
	/*public MedidaMota() {
		super();
		sensorGps= new SensorGps();
	}*/
	
	public MedidaMota(Mota mota) {
		super();
		this.mota = mota;
		mota.getMedidasMota().add(this);
		sensorGps= new SensorGps();
	}
	
	public MedidaMota() {
		super();
	}

	public abstract String getTipo();
	public  String getTextoHtml() {
		 return getMota().getDescripcion()+"<hr>"+UtilesVista.filaSensor("Fecha medición:", getFechaMedida().toLocaleString())+"<br>"+getSensorGps().getTextoHtml();
	}
	
	public String getTipoCss() {
		return UtilesVista.getTipoCss(getTipo());
	}
	public String getTipoCssGrande() {
		return UtilesVista.getTipoCssGrande(getTipo());
	}
	
	public  void setPropiedadesDto(MedidaMotaDto dto) {
		dto.setIdMedida(idMedida);
		dto.setFechaMedida(fechaMedida);
		dto.getSensorGps().getPosicion().setLatitud(sensorGps.getPosicion().getLatitud());
		dto.getSensorGps().getPosicion().setLongitud(sensorGps.getPosicion().getLongitud());
		dto.getSensorGps().getPosicion().setAltitud(sensorGps.getPosicion().getAltitud());
		dto.setTextoMedidaHtml(getTextoHtml());
	}
	
	public  void setPropiedadesMedidaMota(MedidaMotaDto dto) {
		setIdMedida(dto.getIdMedida());
		setFechaMedida(dto.getFechaMedida());
	}
	public Integer getIdMota() {
		return idMota;
	}


	public void setIdMota(Integer idMota) {
		this.idMota = idMota;
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
	public Mota getMota() {
		return mota;
	}
	
	public SensorGps getSensorGps() {
		return sensorGps;
	}


	public void setSensorGps(SensorGps sensorGps) {
		this.sensorGps = sensorGps;
	}


	/* Impedimos que se pueda asignar una "MedidaMota" que no le corresponda
	 * Solo las subclases y las del paquete podrán establecer la mota.
	 * */
	protected void setMota(Mota mota) {
		this.mota = mota;
	}
	
	/**
	 * Anular mota.Útil antes de enviarlo como respuesta JSON para evitar ciclos.
	 *  Ya que tienen una relación bidireccional.
	 */
	public void anularMota() {
		this.mota=null;
	}
	
	@Override
	public String toString() {
		return "MedidaMota [idMedida=" + idMedida + ", fechaMedida=" + fechaMedida  + "]";
	}
	
	
	
}
