package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Reserva;
import com.example.demo.repository.IReservaRepository;

@Service
public class ReservaServiceImpl implements IReservaService{
	
	@Autowired
	private IReservaRepository iReservaRepository;

	@Override
	public void insertar(Reserva reserva) {
		// TODO Auto-generated method stub
		reserva.setEstado("G");
		this.iReservaRepository.insertar(reserva);
	}

	@Override
	public Reserva buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iReservaRepository.buscarNumero(numero);
	}

	@Override
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepository.actualizar(reserva);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iReservaRepository.eliminar(numero);
	}
	
}
