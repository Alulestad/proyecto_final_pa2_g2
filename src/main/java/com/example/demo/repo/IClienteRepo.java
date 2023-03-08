package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Cliente;

public interface IClienteRepo {
	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public Cliente buscarPorCedula(String cedula);

	public Cliente buscarPorUsuario_contrasenia(String usuario, String contrasenia);

	public List<Cliente> buscarPorApellido(String apellido);

	public void eliminar(String cedula);
	
	public List<Cliente> buscarTodos();
}
