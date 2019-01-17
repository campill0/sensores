package com.aytocartagena.model.motas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.medidas.MedidaMota;
import com.aytocartagena.util.Constantes;
import com.aytocartagena.util.UtilesVista;
import com.google.gson.annotations.Expose;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
@Entity
@Table(name = Constantes.PREFIJO_TABLAS + "mota")
@DiscriminatorColumn(name="TIPO")
@Inheritance(strategy = javax.persistence.InheritanceType.SINGLE_TABLE)
public abstract class Mota {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "mota_id")
	private Integer idMota;
	private String descripcion;
	private Integer numInventario;
	private  String fabricante;
	private String modelo;
	private String urlFichaProductoFabricante;

	public Mota() {
		super();
	}

	@OneToMany(mappedBy = "mota", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<MedidaMota> medidasMota = new ArrayList<MedidaMota>() ;
	
	public abstract String getTipo();
	
	public String getTipoCss() {
		return UtilesVista.getTipoCss(getTipo());
	}
	public String getTipoCssGrande() {
		return UtilesVista.getTipoCssGrande(getTipo());
	}
	
	public void setPropiedadesDto(MotaDto dto) {
		setPropiedadesMotaDto(dto);
	}
	
	public  void setPropiedadesMota(MotaDto dto) {
		setPropiedadesMotaPrivado(dto);
	}
	private void setPropiedadesMotaPrivado(MotaDto dto) {
		this.setIdMota(dto.getIdMota());
		this.setDescripcion(dto.getDescripcion());
		this.setNumInventario(dto.getNumInventario());
		this.setFabricante(dto.getFabricante());
		this.setModelo(dto.getModelo());
		this.setUrlFichaProductoFabricante(dto.getUrlFichaProductoFabricante());
		
	}
	private void setPropiedadesMotaDto(MotaDto dto) {
		dto.setIdMota(this.idMota);
		dto.setDescripcion(this.descripcion);
		dto.setNumInventario(this.numInventario);
		dto.setFabricante(this.fabricante);
		dto.setModelo(this.modelo);
		dto.setUrlFichaProductoFabricante(this.urlFichaProductoFabricante);
	}
	
	
	public Integer getIdMota() {
		return idMota;
	}
	public void setIdMota(Integer idMota) {
		this.idMota = idMota;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getNumInventario() {
		return numInventario;
	}
	public void setNumInventario(Integer numInventario) {
		this.numInventario = numInventario;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getUrlFichaProductoFabricante() {
		return urlFichaProductoFabricante;
	}
	public void setUrlFichaProductoFabricante(String urlFichaProductoFabricante) {
		this.urlFichaProductoFabricante = urlFichaProductoFabricante;
	}
	public List<MedidaMota> getMedidasMota() {
		return medidasMota;
	}
	public void setMedidasMota(List<MedidaMota> medidasMota) {
		this.medidasMota = medidasMota;
	}
	
	@Override
	public String toString() {
		return "Mota [idMota=" + idMota + ", descripcion=" + descripcion + ", numInventario=" + numInventario
				+ ", fabricante=" + fabricante + ", modelo=" + modelo + ", urlFichaProductoFabricante="
				+ urlFichaProductoFabricante + ", medidasMota=" + medidasMota + "]";
	}
	
	
}
