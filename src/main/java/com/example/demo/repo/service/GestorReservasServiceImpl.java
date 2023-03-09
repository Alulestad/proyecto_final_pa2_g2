package com.example.demo.repo.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Cobro;
import com.example.demo.repo.modelo.Reservacion;
import com.example.demo.repo.modelo.Vehiculo;

@Service
public class GestorReservasServiceImpl implements IGestorReservasServiceImpl{
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IReservacionService iReservacionService;
	
	private ICobroService cobroService;

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

	@Override
	public Reservacion reservarVehiculo(String placa, String cedula, LocalDateTime fechaInicio,
			LocalDateTime fechaFinal, String numeroTarjeta) {
		// TODO Auto-generated method stub
		Vehiculo vehi=this.iVehiculoService.buscarPorPlaca(placa);
		Duration duracion=Duration.between(fechaInicio, fechaFinal);
		long dias=duracion.toDays();
		
		Cliente cliente=this.clienteService.buscar(cedula);
		
		List<Reservacion> reservasCliente=cliente.getReservaciones();
		if(reservasCliente==null) {
			reservasCliente=new ArrayList<>();
		}
		
		Reservacion reservacion=new Reservacion();
		reservacion.setCliente(cliente);
		reservacion.setFechaFin(fechaFinal);
		reservacion.setFechaInicio(fechaInicio);
		reservacion.setVehiculo(vehi);
		this.iReservacionService.insertarReservacionPl(reservacion);
		
		List<Reservacion> reservaVehiculo=vehi.getReservaciones();
		if(reservaVehiculo==null){
			reservaVehiculo=new ArrayList<>();
		}
		reservaVehiculo.add(reservacion);
		vehi.setReservaciones(reservaVehiculo);
		this.iVehiculoService.actualizar(vehi);
		
		reservasCliente.add(reservacion);
		cliente.setReservaciones(reservasCliente);
		this.clienteService.actualizar(cliente);
		
		
		this.cobroService.insertarCobro(numeroTarjeta, vehi.getValorDia(), (int) dias,reservacion.getId());
		
		
		return null;
	}

}
