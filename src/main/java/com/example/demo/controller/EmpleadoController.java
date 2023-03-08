package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.DTO.ClienteDTO;
import com.example.demo.modelo.DTO.ReservaDTO;
import com.example.demo.modelo.DTO.VehiculoDTO;
import com.example.demo.repo.modelo.Empleado;
import com.example.demo.repo.service.IEmpleadoService;


@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("")
	public String paginaInicio() {
		return "vistainicioEmpleado";
	}
	
	@GetMapping("/registrar")
	public String registrarEmpleado(Empleado empleado) {
		return "vistaEmpleadoInsertar";
	}
	
	@PostMapping("/insertado")
	public String insertarPersona(Empleado empleado) {
		this.empleadoService.insertarEmpleado(empleado);
		return "redirect:/empleado/registrar";
	}
////////////////////////////////////////////////REPORTEVIP//////////
	@GetMapping("/consultarReporteVIP")
	public String consultarReporteVIP(ReservaDTO reserva) {
		return "vistainsertarReporteVIP";
	}
	
	@GetMapping("/reporteVIP")
	public String buscarTodos(ReservaDTO reserva, Model modelo) {
		List<ReservaDTO> lista = this.empleadoService.reporteVIP(LocalDateTime.parse(reserva.getFechaInicio()),
				LocalDateTime.parse(reserva.getFechaFin()));
		modelo.addAttribute("reservas", lista);
		return "vistaReporteVIP";
	}
////////////////////////////////////////////////REPORTEVIP//////////
	
	
	
//////////////////////////////////////////////CLIENTESVIP//////////
	
	@GetMapping("/clientesVIP")
	public String buscar(Model modelo) {
		List<ClienteDTO> lista = this.empleadoService.clientesVIP();
		modelo.addAttribute("clientes", lista);
		return "vistaClientesVIP";
	}

//////////////////////////////////////////////CLIENTESVIP//////////
	

////////////////////////////////////////////VEHICULOSVIP//////////
	@GetMapping("/generarVehiculoVip")
	public String generarBusquedaVehiculos(VehiculoDTO vehiculo, Model modelo) {
		modelo.addAttribute("vehiculoVIP", vehiculo);
		return "vistaGenerarVehiculoVIP";
	}
	
	@GetMapping("/buscarVehiculosVIP")
	public String buscarVehiculosVIP(VehiculoDTO vehiculo, Model modelo) {
		List<VehiculoDTO> vip = this.empleadoService.vehiculosVIP(vehiculo.getAnio(), vehiculo.getMes());
		modelo.addAttribute("vips", vip);
		return "vistaVehiculosVIP";
	}
	
	
}
