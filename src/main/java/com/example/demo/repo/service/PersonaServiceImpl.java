package com.example.demo.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IClienteRepo;
import com.example.demo.repo.IEmpleadoRepo;
import com.example.demo.repo.modelo.Persona;

@Service
public class PersonaServiceImpl implements IClienteService, IEmpleadoService{

	@Autowired
	private IClienteRepo clienteRepo;
	
	@Autowired
	private IEmpleadoRepo empleadoRepo;
	
	
	@Override
	public Persona buscarEmpleadoId(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarEmpleadoId(id);
	}

	@Override
	public Persona buscarEmpleadoCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarEmpleadoCedula(cedula);
	}

	@Override
	public void borrarEmpleadoId(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepo.eliminarEmpleadoId(id);
	}

	@Override
	public void borrarEmpleadoCedula(String cedula) {
		// TODO Auto-generated method stub
		this.empleadoRepo.buscarEmpleadoCedula(cedula);
	}

	@Override
	public void registrarEmpleado(Persona empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.insertarEmpleado(empleado);
	}

	@Override
	public void actualizarEmpleado(Persona empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.actualizarEmpleado(empleado);
	}

	@Override
	public List<Persona> buscarEmpleados(String registro) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarEmpleados(registro);
	}

	@Override
	public Persona buscarClienteId(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarClienteId(id);
	}

	@Override
	public Persona buscarClienteCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.buscarClienteCedula(cedula);
	}

	@Override
	public void borrarClienteId(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepo.buscarClienteId(id);
	}

	@Override
	public void borrarClienteCedula(String cedula) {
		// TODO Auto-generated method stub
		this.clienteRepo.eliminarClienteCedula(cedula);
	}

	@Override
	public void registrarCliente(Persona cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertarCliente(cliente);
	}

	@Override
	public void actualizarCliente(Persona cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizarCliente(cliente);
	}

	@Override
	public List<Persona> buscarClientes(String registro) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarClientes(registro);
	}

}
