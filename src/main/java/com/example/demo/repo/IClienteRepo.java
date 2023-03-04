package com.example.demo.repo;

import com.example.demo.repo.modelo.Cliente;

public interface IClienteRepo {
	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public Cliente buscarPorCedula(String cedula);

	public void eliminar(String cedula);
}
