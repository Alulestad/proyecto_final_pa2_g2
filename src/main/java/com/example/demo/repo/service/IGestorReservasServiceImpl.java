package com.example.demo.repo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorReservasServiceImpl {
	
	public BigDecimal calculoPagoVehiculo(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFin);

	
}
