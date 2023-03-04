package com.example.demo.repo.service;

import java.util.List;

import com.example.demo.repo.modelo.Persona;

public interface IClienteService {

	public Persona buscarClienteId(Integer id);

	public Persona buscarClienteCedula(String cedula);

	public void borrarClienteId(Integer id);

	public void borrarClienteCedula(String cedula);

	public void registrarCliente(Persona cliente);

	public void actualizarCliente(Persona cliente);
	
	public List<Persona> buscarClientes(String registro);
}
