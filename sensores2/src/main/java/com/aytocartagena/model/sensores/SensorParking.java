package com.aytocartagena.model.sensores;

import java.util.Arrays;

import org.hibernate.annotations.ColumnDefault;

import com.aytocartagena.util.UtilesVista;

public class SensorParking extends Sensor {
	@ColumnDefault(value = "0")
	private boolean ocupado;

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String getTextoHtml() {
		return 	UtilesVista.infoSensor("Sensor de Temperatura",
				Arrays.asList(
						new UtilesVista.Propiedad("Ocupado:",ocupado? "Si":"No")
						));
	}
	
}
