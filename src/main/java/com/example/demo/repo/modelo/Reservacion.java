package com.example.demo.repo.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="reservacion")
public class Reservacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_rese")
	@SequenceGenerator(name = "seq_rese",sequenceName = "seq_rese",allocationSize = 1)
	@Column(name="rese_id")
	private Integer id;

	@Column(name="rese_placa")
	private String placa;

	@Column(name="rese_cedula")
	private String cedula;

	@Column(name="rese_fecha_inicio")
	private LocalDateTime fechaInicio;

	@Column(name="rese_fecha_fin")
	private LocalDateTime fechaFin;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rese_id_vehiculo")
	private Vehiculo vehiculo;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rese_id_cliente")
	private Persona cliente;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rese_id_cobro")
	private Cobro cobro;
	
	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Cobro getCobro() {
		return cobro;
	}

	public void setCobro(Cobro cobro) {
		this.cobro = cobro;
	}


	//TO STRING
	@Override
	public String toString() {
		return "Reservacion [id=" + id + ", placa=" + placa + ", cedula=" + cedula + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", vehiculo=" + vehiculo + ", cliente=" + cliente + ", cobro=" + cobro
				+ "]";
	}

	
}