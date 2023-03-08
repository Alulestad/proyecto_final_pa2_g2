package com.example.demo.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clien_id_seq")
	@SequenceGenerator(name = "clien_id_seq", sequenceName = "clien_id_seq", allocationSize = 1)
	@Column(name = "clien_id")
	private Integer id;

	@Column(name = "clien_cedula")
	private String cedula;

	@Column(name = "clien_nombre")
	private String nombre;

	@Column(name = "clien_apellido")
	private String apellido;

	@Column(name = "clien_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@Column(name = "clien_genero")
	private String genero;

	@Column(name = "clien_registro")
	private String registro;

	@OneToMany(mappedBy = "cliente")
	private List<Reserva> reservas;

	//GET Y SET
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	//TO STRING

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", registro=" + registro
				+ ", reservas=" + reservas + "]";
	}
	
	
	
	
	

}
