package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Vehiculo;

public interface IReservaRepository {
	
	public void insertar (Reserva reserva);
	
	public Reserva buscarNumero(String numero);
	
	public List<Reserva>buscarPorVehiculo(Vehiculo vehiculo);
	
	public void actualizar(Reserva reserva);
	
	public void eliminar(String numero);
	
	public List<Reserva>reporte(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	
}
