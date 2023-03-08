package com.example.demo.modelo.DTO;

import java.math.BigDecimal;

public class ClienteDTO implements Comparable<ClienteDTO> {

	private String cedula;

	private String nombre;

	private String apellido;

	private BigDecimal valorTotal;

	private BigDecimal iva;

	@Override
	public int compareTo(ClienteDTO o) {
		// TODO Auto-generated method stub

		return this.valorTotal.compareTo(o.getValorTotal());
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	
	
}