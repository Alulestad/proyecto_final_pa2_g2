package com.example.demo.repo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Reservacion;

public interface IReservacionService {
	
	//CRUD
	public Reservacion buscarReservacionPl(String placa);
	public List<Reservacion>  buscarReservacionPorFecha(LocalDateTime fechaInicio,LocalDateTime fechaFin);
	public List<Reservacion>reporte(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	public boolean verificarReservacionPorCedula_Placa_Fechas(String cedula, String placa,
			LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	public List<Reservacion> listaReservacionPorCedula_Placa_Fechas(String cedula, String placa, LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	public void eliminarReservacionPl(String placa);
	public void insertarReservacionPl(Reservacion reservacion);
	public void actualizarReservacionPl(Reservacion reservacion);

}
