package com.example.demo.repo.modelo;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "mecanico")
public class Mecanico {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mecanico")
	@SequenceGenerator(name = "seq_mecanico", sequenceName = "seq_mecanico", allocationSize = 1)
	@Column(name = "mec_id")
	private Integer id;
	@Column(name = "mec_cedula")
	private String cedula;
	@Column(name = "mec_nombre")
	private String nombre;
	@Column(name = "mec_genero")
	private String genero;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Mecanico [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", genero=" + genero + "]";
	}

	

	


}
