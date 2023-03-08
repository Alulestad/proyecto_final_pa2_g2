package com.example.demo.modelo.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Reservacion;

public class VehiculoDTO implements Comparable<VehiculoDTO>{

	private String placa;

	private String modelo;

	private String marca;

	private String anioFabricacion;

	private BigDecimal valorPorDia;
	
	private BigDecimal subTotal;
	
	private BigDecimal totalPagar;
	
	private String anio;

	private String mes;
	
	private String estado;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private String numeroReserva;
    
    private List<Reservacion> reservaciones;
    

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

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
    
	
	
	public List<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}

	
	

	@Override
	public String toString() {
		return "VehiculoDTO [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", anioFabricacion="
				+ anioFabricacion + ", valorPorDia=" + valorPorDia + ", subTotal=" + subTotal + ", totalPagar="
				+ totalPagar + ", anio=" + anio + ", mes=" + mes + ", estado=" + estado + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", numeroReserva=" + numeroReserva + ", reservaciones=" + reservaciones
				+ "]";
	}

	@Override
	public int compareTo(VehiculoDTO o) {
		// TODO Auto-generated method stub
		
		
		return this.totalPagar.compareTo(o.getTotalPagar());
	}
    
}
