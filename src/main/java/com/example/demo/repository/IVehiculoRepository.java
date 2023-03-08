package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);
	
	public List<Vehiculo> buscarTodos();
	
	public Vehiculo buscarPlaca(String placa);
	
	public List<Vehiculo> buscarMarca(String marca);
	
	public void actualizar(Vehiculo vehiculo);
	
	public void eliminar(String placa);
}
