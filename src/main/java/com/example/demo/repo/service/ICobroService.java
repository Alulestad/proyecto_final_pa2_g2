package com.example.demo.repo.service;

import java.math.BigDecimal;

import com.example.demo.repo.modelo.Cobro;

public interface ICobroService {

	//CRUD
	public Cobro buscarCobroId(Integer id);
	public void eliminarCobroId(Integer id);
	public void insertarCobro(Cobro cobro);
	public void insertarCobro(String targetaCredito, BigDecimal valorDia,Integer numeroDias,Integer idReservacion);
	public void actualizarCobro(Cobro cobro);
}
