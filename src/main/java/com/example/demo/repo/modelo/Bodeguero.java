package com.example.demo.repo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodeguero")
public class Bodeguero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bod")
	@SequenceGenerator(name = "seq_bod", sequenceName = "seq_bod", allocationSize = 1)
	@Column(name = "bod_id")
	private Integer id;

	@Column(name = "bod_nombre")
	private String nombre;
	@Column(name = "bod_apellido")
	private String apellido;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	
	

}
