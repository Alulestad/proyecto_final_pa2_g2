package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.DTO.ClienteDTO;
import com.example.demo.modelo.DTO.ReservaDTO;
import com.example.demo.modelo.DTO.VehiculoDTO;
import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.IReservaRepository;
import com.example.demo.repository.IVehiculoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IReservaRepository reservaRepository;
	
	
	@Override
	public void registrarCliente(Cliente cliente) {
		cliente.setRegistro("E");
		this.clienteRepository.insertar(cliente);
	}

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		vehiculo.setEstado("D");
		this.vehiculoRepository.insertar(vehiculo);
	}

	@Override
	public List<ReservaDTO> reporteVIP(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		List<Reserva> reserva = this.reservaRepository.reporte(fechaInicio, fechaFin);
		
		List<ReservaDTO> vip = reserva.stream().map(r -> {
			ReservaDTO reporte = new ReservaDTO();

			reporte.setSubTotal(r.getSubTotal());
			reporte.setIva(r.getIva());
			reporte.setTotalPagar(r.getTotalPagar());
			reporte.setEstadoReporte(r.getEstado());

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
		List<Cliente> clientes = this.clienteRepository.buscarTodos();
		
		List<ClienteDTO> vip = clientes.stream().map(c -> {
			ClienteDTO cliente = new ClienteDTO();
			cliente.setCedula(c.getCedula());
			cliente.setNombre(c.getNombre());
			cliente.setApellido(c.getApellido());
			BigDecimal valorSuma = BigDecimal.ZERO;
			if (c.getReservas() != null) {
				for (Reserva item : c.getReservas()) {
					valorSuma = valorSuma.add(item.getTotalPagar());
				}
			}
			cliente.setValorTotal(valorSuma);
			cliente.setIva(valorSuma.multiply(new BigDecimal(12).divide(new BigDecimal(100))));

			return cliente;
		}).filter(c -> !c.getValorTotal().equals(BigDecimal.ZERO)).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

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

		List<Vehiculo> vehiculos = this.vehiculoRepository.buscarTodos();

		for (Vehiculo v : vehiculos) {
			if (v.getReservas() != null) {
				List<Reserva> reservas = v.getReservas().stream().filter(
						r -> r.getFechaInicio().compareTo(fechaInicio) >= 0 && r.getFechaFin().compareTo(fechaFin) < 0)
						.collect(Collectors.toList());
				v.setReservas(reservas);
			}
		}

		List<VehiculoDTO> vip = vehiculos.stream().filter(v -> v.getReservas() != null).map(v -> {
			VehiculoDTO vehiculo = new VehiculoDTO();
			vehiculo.setPlaca(v.getPlaca());
			vehiculo.setModelo(v.getModelo());
			vehiculo.setMarca(v.getMarca());
			vehiculo.setAnioFabricacion(v.getAnioFabricacion());
			vehiculo.setValorPorDia(v.getValorPorDia());

			BigDecimal total = BigDecimal.ZERO;
			BigDecimal subTotal = BigDecimal.ZERO;

			for (Reserva item : v.getReservas()) {
				total = total.add(item.getTotalPagar());
				subTotal = subTotal.add(item.getSubTotal());
			}
			vehiculo.setTotalPagar(total);
			vehiculo.setSubTotal(subTotal);

			return vehiculo;
		}).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		return vip;
	}

	@Override
	public List<Cliente> verClientes() {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscarTodos();
	}

	@Override
	public List<Vehiculo> verVehiculos() {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarTodos();
	}

}
