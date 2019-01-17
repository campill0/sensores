package com.aytocartagena.controller.dto;

import java.util.Date;

import com.aytocartagena.controller.view.Tipificable;
import com.aytocartagena.model.Direccion;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.model.motas.MotaAguaBasica;
import com.aytocartagena.model.motas.MotaContaminacionBasica;
import com.aytocartagena.model.motas.MotaGps;
import com.aytocartagena.model.motas.MotaParking;
import com.aytocartagena.util.Constantes;
import com.aytocartagena.util.UtilesVista;
import com.mysql.jdbc.Util;

public class MotaDto implements Tipificable{
	//--------------MOTA----------------------
	private String tipoMota;
	private Integer idMota;
	private String descripcion;
	private Integer numInventario;
	private String fabricante;
	private String modelo;
	private String urlFichaProductoFabricante;
	//--------------MOTA_AGUA_BASICA-----------------------------
	private String lugar;
	//--------------MOTA_CONTAMINACION_BASICA-----------------------------
	private Date ultimaRevision;
	private String notasRevision;
	//--------------MOTA_PARKING-----------------------------
	private Direccion direccion;
	//--------------MOTA_POSICIONADA,MOTA_GPS-----------------------------
	private Posicion posicion;
	
	public MotaDto() {
		super();
		inicializarDto();
	}

	public MotaDto(Mota mota) {
		super();
		inicializarDto();
		mota.setPropiedadesDto(this);
	}
	
	private void inicializarDto() {
		this.direccion= new Direccion();
		this.ultimaRevision= new Date();
		this.posicion = new Posicion();
		this.idMota= new Integer(0);
		this.numInventario= new Integer(0);
	}
	
	/**
	 * Construye una mota del tipo indicado en tipoMota.
	 *
	 * @return the mota
	 */
	public Mota buildMota() {
		Mota mota=null;
		switch (tipoMota) {
        case Constantes.TiposMota.AGUA_BASICA:mota= new MotaAguaBasica();break;
        case Constantes.TiposMota.CONTAMINACION_BASICA: mota= new MotaContaminacionBasica();break;
        case Constantes.TiposMota.GPS: mota= new MotaGps();break;
        case Constantes.TiposMota.PARKING: mota= new MotaParking();break;
		}
		if (mota!=null) {
			mota.setPropiedadesMota(this);
			return mota;
		}
		return null;
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

	public String getTipoMota() {
		return tipoMota;
	}

	public void setTipoMota(String tipoMota) {
		this.tipoMota = tipoMota;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public Date getUltimaRevision() {
		return ultimaRevision;
	}

	public void setUltimaRevision(Date ultimaRevision) {
		this.ultimaRevision = ultimaRevision;
	}

	public String getNotasRevision() {
		return notasRevision;
	}
	public void setNotasRevision(String notasRevision) {
		this.notasRevision = notasRevision;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public String getTipoCss() {
		return UtilesVista.getTipoCss(tipoMota);
	}

	@Override
	public String getTipoCssGrande() {
		return UtilesVista.getTipoCssGrande(tipoMota);
	}


	

}
