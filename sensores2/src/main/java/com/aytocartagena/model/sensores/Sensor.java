package com.aytocartagena.model.sensores;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.aytocartagena.util.Constantes;

@Embeddable
public abstract class Sensor {
	public abstract String getTextoHtml();
	
}
