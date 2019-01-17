package com.aytocartagena.model.medidas;

import javax.persistence.Entity;

import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.model.motas.MotaPosicionada;
@Entity
public abstract class MedidaMotaPosicionada extends MedidaMota{
	
	public MedidaMotaPosicionada() {
		super();
	}

	public MedidaMotaPosicionada(Mota mota) {
		super(mota);
	}

	public MedidaMotaPosicionada(MotaPosicionada motaPosicionada) {
		super(motaPosicionada);
		getSensorGps().getPosicion().setLatitud(motaPosicionada.getPosicion().getLatitud());
		getSensorGps().getPosicion().setLongitud(motaPosicionada.getPosicion().getLongitud());
		getSensorGps().getPosicion().setAltitud(motaPosicionada.getPosicion().getAltitud());
		
	}
	
}
