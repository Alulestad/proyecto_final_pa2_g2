package com.example.demo.repo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.repo.modelo.Reservacion;

public interface IGestorReservasServiceImpl {
	
	public BigDecimal calculoPagoVehiculo(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFin);

	public Reservacion reservarVehiculo(String placa, String cedula, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
			String numeroTarjeta);
	
}
