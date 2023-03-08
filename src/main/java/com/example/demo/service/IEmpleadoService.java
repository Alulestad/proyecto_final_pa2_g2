package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.DTO.ClienteDTO;
import com.example.demo.modelo.DTO.ReservaDTO;
import com.example.demo.modelo.DTO.VehiculoDTO;

public interface IEmpleadoService {

	public void registrarCliente(Cliente cliente);
	
	public void ingresarVehiculo(Vehiculo vehiculo);

	public List<ReservaDTO> reporteVIP(LocalDateTime fechaInicio, LocalDateTime fechaFin);

	public List<ClienteDTO> clientesVIP();

	public List<VehiculoDTO> vehiculosVIP(String anio, String mes);

	public List<Cliente> verClientes();
	
	public List<Vehiculo>verVehiculos();
}
