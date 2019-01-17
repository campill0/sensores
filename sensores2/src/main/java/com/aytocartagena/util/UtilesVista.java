package com.aytocartagena.util;

import java.util.List;

/**
 * Clase de métodos útiles para ser utilizados en la Vista.
 */
public class UtilesVista {
	
	/**
	 * Obtiene el nombre del tipo de mota en una nomenclatura 
	 * apta para ser usada en una clase css
	 *
	 * @return the tipo css
	 */
	public static String getTipoCss(String tipo) {
		String classCss="";
		switch(tipo) {
		case Constantes.TiposMota.AGUA_BASICA:
			classCss = "fa fa-tint";
			break;
		case Constantes.TiposMota.CONTAMINACION_BASICA:
			classCss = "fas fa-biohazard";
			break;
		case Constantes.TiposMota.GPS:
			classCss = "fas fa-map-marked-alt";
			break;
		case Constantes.TiposMota.PARKING:
			classCss = "fa fa-car";
			break;
		}
		return classCss;
	}
	
	public static String getTipoCssGrande(String tipo){
		return getTipoCss(tipo)+" fa-2x";
	}
	
	
	/** Método para generar html de los sensores para poder mostrarlo dentro del tooltip del mapa **/
	
	private static String etiquetaSensor(String texto) {
		return "<span class='etiquetaSensor'>"+texto+"</span>";
	}
	private static String valorSensor(String texto) {
		return "<span class='valorSensor'>"+texto+"</span>";
	}
	public static String filaSensor(String etiqueta,String valor) {
		return etiquetaSensor(etiqueta)+valorSensor(valor);
	}
	public static String cabeceraSensor(String texto) {
		return "<span class='cabeceraSensor'>"+texto+"</span>";
	}
	public static String infoSensor(String cabecera,List<Propiedad>propiedades ) {
		
		StringBuilder sb= new StringBuilder();
		sb.append(cabeceraSensor(cabecera)).append("<br>");
		for (Propiedad propiedad : propiedades) {
			sb.append(filaSensor(propiedad.etiqueta, propiedad.valor)).append("<br>");
		}
		return sb.toString();
		
	}
	public static class Propiedad {
		private String etiqueta;
		private String valor;
		public Propiedad(String etiqueta, String valor) {
			super();
			this.etiqueta = etiqueta;
			this.valor = valor;
		}
		public String getEtiqueta() {
			return etiqueta;
		}
		public void setEtiqueta(String etiqueta) {
			this.etiqueta = etiqueta;
		}
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		
	}
	
	/** fin de bloque de métodos tooltip de mapas**/

}
