package com.aytocartagena.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.aytocartagena.util.Constantes;
@Entity
@Table(name= Constantes.PREFIJO_TABLAS+"roles")
public class Rol implements Serializable{
	
	private static final long serialVersionUID = 5677648642274679164L;
	
	@Id()
	@Column(name="idrol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRol;
	
	@Column(name="rol", unique=true)
	private String rol;
	
	
	
	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
}
