package com.example.demo.repo.service;

import java.util.List;

import com.example.demo.repo.modelo.Persona;

public interface IEmpleadoService {
	
	public Persona buscarEmpleadoId(Integer id);

	public Persona buscarEmpleadoCedula(String cedula);

	public void borrarEmpleadoId(Integer id);

	public void borrarEmpleadoCedula(String cedula);

	public void registrarEmpleado(Persona empleado);

	public void actualizarEmpleado(Persona empleado);
	
	public List<Persona> buscarEmpleados(String registro);

}
