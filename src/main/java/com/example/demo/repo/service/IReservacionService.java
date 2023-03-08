package com.example.demo.repo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Reservacion;

public interface IReservacionService {
	
	//CRUD
	public Reservacion buscarReservacionPl(String placa);
	public List<Reservacion>  buscarReservacionPorFecha(LocalDateTime fechaInicio,LocalDateTime fechaFin);
	public List<Reservacion>reporte(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	public void eliminarReservacionPl(String placa);
	public void insertarReservacionPl(Reservacion reservacion);
	public void actualizarReservacionPl(Reservacion reservacion);

	
	
	public void reservar(String placa, String cedula, LocalDateTime fechaInicio, LocalDateTime fechaFin);
	
}
