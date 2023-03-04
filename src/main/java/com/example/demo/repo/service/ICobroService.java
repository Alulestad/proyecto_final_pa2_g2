package com.example.demo.repo.service;

import com.example.demo.repo.modelo.Cobro;

public interface ICobroService {

	//CRUD
	public Cobro buscarCobroId(Integer id);
	public void eliminarCobroId(Integer id);
	public void insertarCobro(Cobro cobro);
	public void actualizarCobro(Cobro cobro);
}
