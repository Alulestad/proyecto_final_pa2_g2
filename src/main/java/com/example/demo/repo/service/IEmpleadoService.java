package com.example.demo.repo.service;

import com.example.demo.repo.modelo.Empleado;

public interface IEmpleadoService {
	
	public Empleado buscarEmpleadoId(Integer id);

	public Empleado buscarEmpleadoCedula(String cedula);

	public void eliminarEmpleadoId(Integer id);

	public void eliminarEmpleadoCedula(String cedula);

	public void insertarEmpleado(Empleado empleado);

	public void actualizarEmpleado(Empleado empleado);

}
