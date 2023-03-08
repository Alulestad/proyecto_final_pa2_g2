package com.example.demo.repo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.DTO.ClienteDTO;
import com.example.demo.modelo.DTO.ReservaDTO;
import com.example.demo.modelo.DTO.VehiculoDTO;
import com.example.demo.repo.IClienteRepo;
import com.example.demo.repo.IEmpleadoRepo;
import com.example.demo.repo.IReservacionRepo;
import com.example.demo.repo.IVehiculoRepository;
import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Empleado;
import com.example.demo.repo.modelo.Reservacion;
import com.example.demo.repo.modelo.Vehiculo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepo empleadoRepo;
	
	@Autowired
	private IReservacionRepo iReservacionRepo;
	
	@Autowired
	private IClienteRepo clienteRepo;
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
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

	
	
	
	
	
	@Override
	public List<ReservaDTO> reporteVIP(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
List<Reservacion> reserva = this.iReservacionRepo.reporte(fechaInicio, fechaFin);
		
		List<ReservaDTO> vip = reserva.stream().map(r -> {
			ReservaDTO reporte = new ReservaDTO();

			reporte.setCedula(r.getCliente().getCedula());
			reporte.setApellido(r.getCliente().getApellido());

			reporte.setPlaca(r.getVehiculo().getPlaca());
			reporte.setMarca(r.getVehiculo().getMarca());
			reporte.setModelo(r.getVehiculo().getModelo());

			return reporte;
		}).collect(Collectors.toList());

		return vip;
	}

	@Override
	public List<ClienteDTO> clientesVIP() {
		List<Cliente> clientes = this.clienteRepo.buscarTodos();
		
		List<ClienteDTO> vip = clientes.stream().map(c -> {
			ClienteDTO cliente = new ClienteDTO();
			cliente.setCedula(c.getCedula());
			cliente.setNombre(c.getNombre());
			cliente.setApellido(c.getApellido());
			return cliente;
		}).collect(Collectors.toList());

		return vip;
	}

	
	@Override
	public List<VehiculoDTO> vehiculosVIP(String anio, String mes) {
		// TODO Auto-generated method stub

				if (anio.length() < 4) {
					anio = "20" + anio;
				}
				if (mes.length() < 2) {
					mes = "0" + mes;
				}
				String formatoFecha = anio.concat("-" + mes + "-01T00:00:00");
				LocalDateTime fechaInicio = LocalDateTime.parse(formatoFecha);

				mes = "" + (Integer.parseInt(mes) + 1);

				if (mes.length() < 2)
					mes = "0" + mes;
				formatoFecha = anio.concat("-" + mes + "-01T23:59:00");
				LocalDateTime fechaFin = LocalDateTime.parse(formatoFecha);

				List<Vehiculo> vehiculos = this.iVehiculoRepository.buscarTodos();

				for (Vehiculo v : vehiculos) {
					if (v.getReservaciones() != null) {
						List<Reservacion> reservas = v.getReservaciones().stream().filter(
								r -> r.getFechaInicio().compareTo(fechaInicio) >= 0 && r.getFechaFin().compareTo(fechaFin) < 0)
								.collect(Collectors.toList());
						v.setReservaciones(reservas);
					}
				}

				List<VehiculoDTO> vip = vehiculos.stream().filter(v -> v.getReservaciones() != null).map(v -> {
					VehiculoDTO vehiculo = new VehiculoDTO();
					vehiculo.setPlaca(v.getPlaca());
					vehiculo.setModelo(v.getModelo());
					vehiculo.setMarca(v.getMarca());
					vehiculo.setAnioFabricacion(v.getAnio());
					vehiculo.setValorPorDia(v.getValorDia());
					
					return vehiculo;
				}).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

				return vip;
			}

	@Override
	public List<Empleado> verEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehiculo> verVehiculos() {
		return this.iVehiculoRepository.buscarTodos();
	}

	@Override
	public Empleado buscarPorUsuario_contrasenia(String usuario, String contrasenia) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarPorUsuario_contrasenia(usuario, contrasenia);
	}

}
