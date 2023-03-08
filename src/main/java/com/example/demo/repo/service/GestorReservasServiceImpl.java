package com.example.demo.repo.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.modelo.Vehiculo;

@Service
public class GestorReservasServiceImpl implements IGestorReservasServiceImpl{
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IReservacionService iReservacionService;

	@Override
	public BigDecimal calculoPagoVehiculo(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		Vehiculo vehi=this.iVehiculoService.buscarPorPlaca(placa);
		Duration duracion=Duration.between(fechaInicio, fechaFin);
		Long dias=duracion.toDays();
		
		
		BigDecimal valorSubTotal=vehi.getValorDia().multiply(new BigDecimal(dias));
		BigDecimal valorIva=valorSubTotal.multiply(new BigDecimal(0.12));
		BigDecimal valorTotal=valorSubTotal.add(valorIva);
		
		return valorTotal;
	}

}
