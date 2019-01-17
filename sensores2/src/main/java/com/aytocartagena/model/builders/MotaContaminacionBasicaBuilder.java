package com.aytocartagena.model.builders;
import java.util.Date;

import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.MotaContaminacionBasica;

public  class MotaContaminacionBasicaBuilder {

	private MotaContaminacionBasica mota;
	
	public MotaContaminacionBasicaBuilder() {
		super();
		mota= new MotaContaminacionBasica();
	}
	/** Genéricos de Mota**/
	public MotaContaminacionBasicaBuilder setDescripcion(String descripcion) {mota.setDescripcion(descripcion); return this;}
	public MotaContaminacionBasicaBuilder setNumInventario(Integer numInventario) {mota.setNumInventario(numInventario);return this;}
	public MotaContaminacionBasicaBuilder setFabricante(String fabricante) {mota.setFabricante(fabricante); return this;}
	public MotaContaminacionBasicaBuilder setModelo(String modelo) {mota.setModelo(modelo); return this;}
	public MotaContaminacionBasicaBuilder setUrlFichaProductoFabricante(String urlFichaProductoFabricante) {mota.setUrlFichaProductoFabricante(urlFichaProductoFabricante); return this;}
	
	/** Genéricos de MotaPosicionada**/
	public MotaContaminacionBasicaBuilder setPosicionAltitud(float altitud) {mota.getPosicion().setAltitud(altitud);  return this; 	}
	public MotaContaminacionBasicaBuilder setPosicionLatitud(float latitud) {  mota.getPosicion().setLatitud(latitud);  return this; 	}
	public MotaContaminacionBasicaBuilder setPosicionLongitud(float longitud) {  mota.getPosicion().setLongitud(longitud);  return this; 	}
	
	/** Específicos de Mota Contaminación **/
	public MotaContaminacionBasicaBuilder setUltimaRevision(Date ultimaRevision) {mota.setUltimaRevision(ultimaRevision);return this;}
	public MotaContaminacionBasicaBuilder setNotasRevision(String notasRevision) {mota.setNotasRevision(notasRevision);return this;}
	
	public MotaContaminacionBasica build() {
		return mota;
	}
	
	
}
