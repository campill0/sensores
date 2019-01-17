package com.aytocartagena.model.sensores;

import java.util.Arrays;

import org.hibernate.annotations.ColumnDefault;

import com.aytocartagena.util.UtilesVista;

public class SensorTemperatura extends Sensor {
	@ColumnDefault(value = "0")
	private float temperatura;

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String getTextoHtml() {
		return 	UtilesVista.infoSensor("Sensor de Temperatura",
				Arrays.asList(
						new UtilesVista.Propiedad("Temperatura:",temperatura+"")
						));
	}


}
