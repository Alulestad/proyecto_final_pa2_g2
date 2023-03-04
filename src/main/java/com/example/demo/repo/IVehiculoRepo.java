package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Vehiculo;

public interface IVehiculoRepo {

	public void insertarVehiculo(Vehiculo vehiculo);
	public void eliminarVehiculo(String placa);
	public List<Vehiculo> consultarVehiculo(String marca);
	public void actualizarVehiculo(Vehiculo vehiculo);
	public Vehiculo buscarPlaca(String placa);
	
}
