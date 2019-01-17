package com.aytocartagena.controller.view;

/**
 * La Interface Tipificable.
 * Esta interfaz define métodos comunes que deben implementar
 * aquellas entidades que queramos mostrar en la vista de forma que 
 * se sepa el tipo concreto que se trata dentro de la jerarquia de herencia.
 */
public interface Tipificable {
	public String getTipoCss(); 
	public String getTipoCssGrande();

}
