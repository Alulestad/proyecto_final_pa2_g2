package com.example.demo.repo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.DTO.ClienteDTO;
import com.example.demo.modelo.DTO.ReservaDTO;
import com.example.demo.modelo.DTO.VehiculoDTO;
import com.example.demo.repo.modelo.Empleado;
import com.example.demo.repo.modelo.Vehiculo;

public interface IEmpleadoService {
	
	public Empleado buscarEmpleadoId(Integer id);

	public Empleado buscarEmpleadoCedula(String cedula);

	public void eliminarEmpleadoId(Integer id);

	public void eliminarEmpleadoCedula(String cedula);

	public void insertarEmpleado(Empleado empleado);

	public void actualizarEmpleado(Empleado empleado);
	
	
	
	
	public List<ReservaDTO> reporteVIP(LocalDateTime fechaInicio, LocalDateTime fechaFin);

	public List<ClienteDTO> clientesVIP();

	public List<VehiculoDTO> vehiculosVIP(String anio, String mes);

	public List<Empleado> verEmpleado();
	
	public List<Vehiculo>verVehiculos();

}
