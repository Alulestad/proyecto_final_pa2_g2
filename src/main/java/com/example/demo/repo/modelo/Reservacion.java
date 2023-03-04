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
	
	
	
	@Override
	public String toString() {
		return "Reservacion [id=" + id + ", placa=" + placa + ", cedula=" + cedula + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}

	//Set and Get
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
	
}
