package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Vehiculo;

public interface IVehiculoRepository {

	//Crud
	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarPorMarca(String marca);
	public void eliminar(String placa);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo buscarPorPlaca(String placa);
	
	public List<Vehiculo> buscarTodos();
	
}
