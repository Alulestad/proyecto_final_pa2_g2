package com.example.demo.repo;


import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Empleado;

public interface IEmpleadoRepo {
	// CRUD
	public Empleado buscarEmpleadoId(Integer id);

	public Empleado buscarEmpleadoCedula(String cedula);

	public void eliminarEmpleadoId(Integer id);

	public void eliminarEmpleadoCedula(String cedula);

	public void insertarEmpleado(Empleado empleado);

	public void actualizarEmpleado(Empleado empleado);
	
	
	public Empleado  buscarPorUsuario_contrasenia(String usuario, String contrasenia);
}
