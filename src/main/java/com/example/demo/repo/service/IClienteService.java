package com.example.demo.repo.service;

import java.util.List;

import com.example.demo.repo.modelo.Cliente;

public interface IClienteService {
	public void agregar(Cliente cliente);

	public void actualizar(Cliente cliente);


	public void actualizarPorBusquedaDeCedula(Cliente cliente);

	public Cliente buscar(String cedula);

	public Cliente buscarPorUsuario_contrasenia(String usuario, String contrasenia);

	public void borrar(String cedula);


	public List<Cliente> buscarPorApellido(String apellido);
	
	//Para la vista de empleado
		public List<Cliente> buscarTodos2();
}
