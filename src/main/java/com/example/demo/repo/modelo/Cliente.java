package com.example.demo.repo.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente")
	@SequenceGenerator(name = "seq_cliente",sequenceName = "seq_cliente",allocationSize = 1)
	@Column(name = "clie_id")
	private Integer id;
	@Column(name = "clie_cedula")
	private String cedula;
	@Column(name = "clie_nombre")
	private String nombre;
	@Column(name = "clie_apellido")
	private String apellido;
	@Column(name = "clie_fechaNacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name = "clie_genero")
	private String genero;
	@Column(name = "clie_registro")
	private String registro;
	@Column(name = "clie_usuario")
	private String usuario;
	@Column(name = "clie_contrasenia")
	private String contrasenia;
	@Column(name = "clie_tipo")
	private String tipo;
	
	//aksjfxkjcv
	
}
