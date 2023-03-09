package com.example.demo.repo.modelo;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_vendedor")
	@SequenceGenerator(name = "seq_vendedor",sequenceName = "seq_vendedor",allocationSize = 1)
	@Column(name = "vend_id")
	private Integer id;
	@Column(name = "vend_nombre")
	private String nombre;
	@Column(name = "vend_apellido")
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
	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
	

}
