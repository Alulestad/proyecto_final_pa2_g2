package com.example.demo.repo;


import java.util.List;

import com.example.demo.repo.modelo.Persona;

public interface IEmpleadoRepo {
	// CRUD
	public Persona buscarEmpleadoId(Integer id);

	public Persona buscarEmpleadoCedula(String cedula);

	public void eliminarEmpleadoId(Integer id);

	public void eliminarEmpleadoCedula(String cedula);

	public void insertarEmpleado(Persona empleado);

	public void actualizarEmpleado(Persona empleado);
	
	public List<Persona> buscarEmpleados(String registro);
}
