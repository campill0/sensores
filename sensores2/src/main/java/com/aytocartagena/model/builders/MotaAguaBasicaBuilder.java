package com.aytocartagena.model.builders;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.MotaAguaBasica;

public  class MotaAguaBasicaBuilder {

	private MotaAguaBasica mota;
	
	public MotaAguaBasicaBuilder() {
		super();
		mota= new MotaAguaBasica();
	}
	/** Genéricos de Mota**/
	public MotaAguaBasicaBuilder setDescripcion(String descripcion) {mota.setDescripcion(descripcion); return this;}
	public MotaAguaBasicaBuilder setNumInventario(Integer numInventario) {mota.setNumInventario(numInventario);return this;}
	public MotaAguaBasicaBuilder setFabricante(String fabricante) {mota.setFabricante(fabricante); return this;}
	public MotaAguaBasicaBuilder setModelo(String modelo) {mota.setModelo(modelo); return this;}
	public MotaAguaBasicaBuilder setUrlFichaProductoFabricante(String urlFichaProductoFabricante) {mota.setUrlFichaProductoFabricante(urlFichaProductoFabricante); return this;}
	
	/** Genéricos de MotaPosicionada**/
	public MotaAguaBasicaBuilder setPosicionAltitud(float altitud) {mota.getPosicion().setAltitud(altitud);  return this; 	}
	public MotaAguaBasicaBuilder setPosicionLatitud(float latitud) {  mota.getPosicion().setLatitud(latitud);  return this; 	}
	public MotaAguaBasicaBuilder setPosicionLongitud(float longitud) {  mota.getPosicion().setLongitud(longitud);  return this; 	}
	
	/** Específicos de MotaAguaBasica **/
	public MotaAguaBasicaBuilder setLugar(String lugar) {mota.setLugar(lugar); return this;}
	
	public MotaAguaBasica build() {
		return mota;
	}
	
}
