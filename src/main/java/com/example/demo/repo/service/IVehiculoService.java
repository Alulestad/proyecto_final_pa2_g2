package com.example.demo.repo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Vehiculo;

public interface IVehiculoService {

	//Crud
	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarPorMarca_y_modelo(String marca,String modelo);
	public void eliminar(String placa);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo buscarPorPlaca(String placa);
	public boolean reservar(String placa, String cedula,LocalDateTime inicio, LocalDateTime final_);
	
	public List<Vehiculo> buscarTodos();
	
	public List<Vehiculo> buscarPorMarca(String marca);
}
