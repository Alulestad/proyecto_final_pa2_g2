package com.example.demo.repo;


import com.example.demo.repo.modelo.Reservacion;

public interface IReservacionRepo {
	
	//CRUD
	public Reservacion buscarReservacionPl(String placa);
	public void eliminarReservacionPl(String placa);
	public void insertarReservacionPl(Reservacion reservacion);
	public void actualizarReservacionPl(Reservacion reservacion);
	

}
