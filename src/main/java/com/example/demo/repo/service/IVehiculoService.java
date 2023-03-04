package com.example.demo.repo.service;

import java.util.List;

import com.example.demo.repo.modelo.Vehiculo;

public interface IVehiculoService {

	//Crud
	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarPorMarca(String marca);
	public void eliminar(String placa);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo buscarPorPlaca(String placa);
	
	public List<Vehiculo> buscarTodos();
}
