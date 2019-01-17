package com.aytocartagena.model.builders;
import com.aytocartagena.model.Direccion;
import com.aytocartagena.model.Posicion;
import com.aytocartagena.model.motas.MotaParking;

public  class MotaParkingBuilder {

	private MotaParking mota;
	
	public MotaParkingBuilder() {
		super();
		mota= new MotaParking();
		mota.setDireccion(new Direccion());
		
	}
	/** Genéricos de Mota**/
	public MotaParkingBuilder setDescripcion(String descripcion) {mota.setDescripcion(descripcion); return this;}
	public MotaParkingBuilder setNumInventario(Integer numInventario) {mota.setNumInventario(numInventario);return this;}
	public MotaParkingBuilder setFabricante(String fabricante) {mota.setFabricante(fabricante); return this;}
	public MotaParkingBuilder setModelo(String modelo) {mota.setModelo(modelo); return this;}
	public MotaParkingBuilder setUrlFichaProductoFabricante(String urlFichaProductoFabricante) {mota.setUrlFichaProductoFabricante(urlFichaProductoFabricante); return this;}

	/** Genéricos de MotaPosicionada**/
	public MotaParkingBuilder setPosicionAltitud(float altitud) {mota.getPosicion().setAltitud(altitud);  return this; 	}
	public MotaParkingBuilder setPosicionLatitud(float latitud) {  mota.getPosicion().setLatitud(latitud);  return this; 	}
	public MotaParkingBuilder setPosicionLongitud(float longitud) {  mota.getPosicion().setLongitud(longitud);  return this; 	}
	
	/** Específicos de MotaParking **/
	public MotaParkingBuilder setDireccionCalle(String calle) {mota.getDireccion().setCalle(calle);return this;}
	public MotaParkingBuilder setDireccionNumero(String numero) {mota.getDireccion().setNumero(numero);return this;}
	public MotaParkingBuilder setDireccionCodPostal(String codPostal) {mota.getDireccion().setCodpostal(codPostal);return this;}
	
	public MotaParking build() {
		return mota;
	}
	
}
