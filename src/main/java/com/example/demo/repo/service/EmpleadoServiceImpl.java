package com.example.demo.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEmpleadoRepo;
import com.example.demo.repo.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepo empleadoRepo;
	
	@Override
	public Empleado buscarEmpleadoId(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarEmpleadoId(id);
	}

	@Override
	public Empleado buscarEmpleadoCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarEmpleadoCedula(cedula);
	}

	@Override
	public void eliminarEmpleadoId(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepo.eliminarEmpleadoId(id);
	}

	@Override
	public void eliminarEmpleadoCedula(String cedula) {
		this.empleadoRepo.eliminarEmpleadoCedula(cedula);
	}

	@Override
	public void insertarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.insertarEmpleado(empleado);
	}

	@Override
	public void actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.actualizarEmpleado(empleado);
	}

}
