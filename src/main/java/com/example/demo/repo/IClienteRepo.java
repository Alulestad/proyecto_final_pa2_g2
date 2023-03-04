package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Persona;

public interface IClienteRepo {
	
	public Persona buscarClienteId(Integer id);

	public Persona buscarClienteCedula(String cedula);

	public void eliminarClienteId(Integer id);

	public void eliminarClienteCedula(String cedula);

	public void insertarCliente(Persona cliente);

	public void actualizarCliente(Persona cliente);
	
	public List<Persona> buscarClientes(String registro);
}
