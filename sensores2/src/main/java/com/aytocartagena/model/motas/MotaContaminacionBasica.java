package com.aytocartagena.model.motas;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.util.Constantes;

/**
 * The Class MotaContaminacionBasico.
 */
@Entity
@DiscriminatorValue(value=Constantes.TiposMota.CONTAMINACION_BASICA)
public  class MotaContaminacionBasica extends MotaPosicionada{
	
	/** Fecha de la ultima revisión realizada por el técnico. 
	 * Los sensores de contaminación ambiental se deben revisar regularmente ya que ya que con el uso sus
	 * medidas dejan de ser precisas. Filtros obstruidos, sensores que dejan de estar calibrados, etc...  */
	private Date ultimaRevision;
	
	/** Notas que dejó el técnico en la última revisión de la Mota y sus sensores conectados. */
	private String notasRevision;
	

	@Override
	public String getTipo() {
		return Constantes.TiposMota.CONTAMINACION_BASICA;
	}
	
	@Override
	public void setPropiedadesDto(MotaDto dto) {
		super.setPropiedadesDto(dto);
		setPropiedadesContaminacionBasicaDto(dto);
	}
	
	private void setPropiedadesContaminacionBasicaDto(MotaDto dto) {
		dto.setUltimaRevision(this.ultimaRevision);
		dto.setNotasRevision(this.notasRevision);
		dto.setTipoMota(getTipo());
	}
	

	@Override
	public void setPropiedadesMota(MotaDto dto) {
		super.setPropiedadesMota(dto);
		this.notasRevision=dto.getNotasRevision();
		this.ultimaRevision=dto.getUltimaRevision();
	}
	
	/**
	 * Gets the ultima revision.
	 *
	 * @return the ultima revision
	 */
	public Date getUltimaRevision() {
		return ultimaRevision;
	}
	
	/**
	 * Sets the ultima revision.
	 *
	 * @param ultimaRevision the new ultima revision
	 */
	public void setUltimaRevision(Date ultimaRevision) {
		this.ultimaRevision = ultimaRevision;
	}
	
	/**
	 * Gets the notas revision.
	 *
	 * @return the notas revision
	 */
	public String getNotasRevision() {
		return notasRevision;
	}
	
	/**
	 * Sets the notas revision.
	 *
	 * @param notasRevision the new notas revision
	 */
	public void setNotasRevision(String notasRevision) {
		this.notasRevision = notasRevision;
	}

	@Override
	public String toString() {
		return super.toString()+"MotaContaminacionBasica [ultimaRevision=" + ultimaRevision + ", notasRevision=" + notasRevision + "]";
	}


	
	
}
