package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Vehiculo;

public interface IVehiculoRepository {

	//Crud
	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarPorMarca_y_modelo(String marca,String modelo);
	public List<Vehiculo> buscarTodos();
	public void eliminar(String placa);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo buscarPorPlaca(String placa);
	
}
