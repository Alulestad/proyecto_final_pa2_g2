package com.example.demo.repo;


import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Reservacion;
import com.example.demo.repo.modelo.Vehiculo;

public interface IReservacionRepo {
	
	//CRUD
	public Reservacion buscarReservacionPl(String placa);
	public Reservacion buscarReservacionId(Integer id);
	public List<Reservacion>  buscarReservacionPorFecha(LocalDateTime fechaInicio,LocalDateTime fechaFin);
	public void eliminarReservacionPl(String placa);
	public void insertarReservacionPl(Reservacion reservacion);
	public void actualizarReservacionPl(Reservacion reservacion);
	public List<Reservacion>buscarPorVehiculo(Vehiculo vehiculo);
	public List<Reservacion>reporte(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
