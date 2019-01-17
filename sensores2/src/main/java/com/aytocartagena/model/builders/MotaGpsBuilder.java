package com.aytocartagena.model.builders;
import com.aytocartagena.model.motas.MotaGps;

public  class MotaGpsBuilder {

	private MotaGps mota= new MotaGps();
	
	/** Genéricos de Mota**/
	public MotaGpsBuilder setDescripcion(String descripcion) {mota.setDescripcion(descripcion); return this;}
	public MotaGpsBuilder setNumInventario(Integer numInventario) {mota.setNumInventario(numInventario);return this;}
	public MotaGpsBuilder setFabricante(String fabricante) {mota.setFabricante(fabricante); return this;}
	public MotaGpsBuilder setModelo(String modelo) {mota.setModelo(modelo); return this;}
	public MotaGpsBuilder setUrlFichaProductoFabricante(String urlFichaProductoFabricante) {mota.setUrlFichaProductoFabricante(urlFichaProductoFabricante); return this;}
	
	public MotaGps build() {
		return mota;
	}

}
