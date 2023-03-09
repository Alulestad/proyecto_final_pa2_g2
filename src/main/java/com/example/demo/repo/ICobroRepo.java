package com.example.demo.repo;

import com.example.demo.repo.modelo.Cobro;

public interface ICobroRepo {
	
	//CRUD
	public Cobro buscarCobroId(Integer id);
	public void eliminarCobroId(Integer id);
	public Cobro insertarCobro(Cobro cobro);
	public void actualizarCobro(Cobro cobro);
	
}
