package com.example.demo.repo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IReservacionRepo;
import com.example.demo.repo.modelo.Reservacion;

@Service
public class ReservacionServiceImpl implements IReservacionService {

	@Autowired
	private IReservacionRepo reservacionRepopl;
	@Override
	public Reservacion buscarReservacionPl(String placa) {
		// TODO Auto-generated method stub
		return this.reservacionRepopl.buscarReservacionPl(placa);
	}

	@Override
	public void eliminarReservacionPl(String placa) {
		// TODO Auto-generated method stub
		this.reservacionRepopl.eliminarReservacionPl(placa);
		
	}

	@Override
	public void insertarReservacionPl(Reservacion reservacion) {
		// TODO Auto-generated method stub
		this.reservacionRepopl.insertarReservacionPl(reservacion);
		
	}

	@Override
	public void actualizarReservacionPl(Reservacion reservacion) {
		// TODO Auto-generated method stub
		this.reservacionRepopl.actualizarReservacionPl(reservacion);
		
	}

	@Override
	public List<Reservacion> buscarReservacionPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return this.reservacionRepopl.buscarReservacionPorFecha(fechaInicio, fechaFin);
	}

	@Override
	public List<Reservacion> reporte(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return this.reservacionRepopl.reporte(fechaInicio, fechaFin);
	}

	@Override
	public boolean verificarReservacionPorCedula_Placa_Fechas(String cedula, String placa, LocalDateTime fechaInicio,
			LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		return this.verificarReservacionPorCedula_Placa_Fechas(cedula, placa, fechaInicio, fechaFinal);
	}

	@Override
	public List<Reservacion> listaReservacionPorCedula_Placa_Fechas(String cedula, String placa,
			LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		return this.listaReservacionPorCedula_Placa_Fechas(cedula, placa, fechaInicio, fechaFinal);
	}
	
	
	
	

	
	
}
