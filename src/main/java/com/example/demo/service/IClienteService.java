package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface IClienteService {

	public void insertar(Cliente cliente);

	public Cliente buscar(Integer id);

	public Cliente buscarCedula(String cedula);

	public List<Cliente> buscarApellido(String apellido);

	public void actualizar(Cliente cliente);

	public void eliminar(Integer id);

	public void eliminarPorCedula(String cedula);
}
