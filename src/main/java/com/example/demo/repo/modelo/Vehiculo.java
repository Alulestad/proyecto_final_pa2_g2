package com.example.demo.repo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {


	@Id
	@Column(name = "vehi_placa")
	private String placa;


	@Column(name = "vehi_modelo")
	private String modelo;

	@Column(name = "vehi_marca")
	private String marca;


	@Column(name = "vehi_año")
	private String año;

	@Column(name = "vehi_pais")
	private String pais;

	@Column(name = "vehi_cilindraje")
	private Double cilindraje;

	@Column(name = "vehi_avaluo")
	private BigDecimal avaluo;

	@Column(name = "vehi_estado")
	private String estado;

	@Column(name = "vehi_valor_dia")
	private BigDecimal valorDia;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Reservacion> reservacion;


	
	//GET Y SET
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
	}

	public BigDecimal getAvaluo() {
		return avaluo;
	}

	public void setAvaluo(BigDecimal avaluo) {
		this.avaluo = avaluo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorDia() {
		return valorDia;
	}

	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}
	
	public List<Reservacion> getReservacion() {
		return reservacion;
	}

	public void setReservacion(List<Reservacion> reservacion) {
		this.reservacion = reservacion;
	}
	
	//TO STRING

	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", año=" + año + ", pais="
				+ pais + ", cilindraje=" + cilindraje + ", avaluo=" + avaluo + ", estado=" + estado + ", valorDia="
				+ valorDia + ", reservacion=" + reservacion + "]";
	}	
	

	

	
	
	
	
	
	
	
}