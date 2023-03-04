package com.example.demo.repo.service;

import com.example.demo.repo.modelo.Cliente;

public interface IClienteService {
	public void agregar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public Cliente buscar(String cedula);

	public void borrar(String cedula);
}
