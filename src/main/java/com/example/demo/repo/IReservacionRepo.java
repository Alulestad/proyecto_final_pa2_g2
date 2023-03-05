package com.example.demo.repo;


import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Reservacion;

public interface IReservacionRepo {
	
	//CRUD
	public Reservacion buscarReservacionPl(String placa);
	public void eliminarReservacionPl(String placa);
	public void insertarReservacionPl(Reservacion reservacion);
	public void actualizarReservacionPl(Reservacion reservacion);
	public List<Reservacion> fechaReservas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	

}
