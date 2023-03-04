package com.example.demo.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "cobro")
public class Cobro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cobro")
	@SequenceGenerator(name = "seq_cobro",sequenceName = "seq_cobro",allocationSize = 1)
	@Column(name = "cobr_id")
	private Integer Id;
	@Column(name = "cobr_targeta_credito")
	private String targetaCredito;
	@Column(name = "cobr_valor_subtotal")
	private BigDecimal valorSubtotal;
	@Column(name = "cobr_valor_valorIva")
	private BigDecimal valorIva;
	@Column(name = "cobr_valor_total")
	private BigDecimal valorTotal;
	@Column(name = "cobr_fecha")
	private LocalDateTime fecha;
	
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getTargetaCredito() {
		return targetaCredito;
	}
	public void setTargetaCredito(String targetaCredito) {
		this.targetaCredito = targetaCredito;
	}
	public BigDecimal getValorSubtotal() {
		return valorSubtotal;
	}
	public void setValorSubtotal(BigDecimal valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}
	public BigDecimal getValorIva() {
		return valorIva;
	}
	public void setValorIva(BigDecimal valorIva) {
		this.valorIva = valorIva;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Cobro [Id=" + Id + ", targetaCredito=" + targetaCredito + ", valorSubtotal=" + valorSubtotal
				+ ", valorIva=" + valorIva + ", valorTotal=" + valorTotal + ", fecha=" + fecha + "]";
	}
	
	
	

}
