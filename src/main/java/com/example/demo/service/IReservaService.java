package com.example.demo.service;

import com.example.demo.modelo.Reserva;

public interface IReservaService{

	public void insertar(Reserva reserva);

	public Reserva buscarNumero(String numero);

	public void actualizar(Reserva reserva);

	public void eliminar(String numero);
}
