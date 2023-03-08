package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Cobro;
import com.example.demo.repo.modelo.Reservacion;
import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.repo.service.IClienteService;
import com.example.demo.repo.service.ICobroService;
import com.example.demo.repo.service.IReservacionService;
import com.example.demo.repo.service.IVehiculoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IReservacionService reservacionService;
	
	@Autowired 
	private ICobroService cobroService;

	@GetMapping("/inicio")
	public String inicioCliente(Cliente cliente) {
		return "Cliente/vistaLogin";
		// return "Cliente/vistaInicioCliente";
	}

	@GetMapping("/login")
	public String ingresar(Model model, @Param("contrasenia") String contrasenia, @Param("usuario") String usuario) {
		Cliente user = this.clienteService.buscarPorUsuario_contrasenia(usuario, contrasenia);
		model.addAttribute("clientes", user);
		model.addAttribute("contrasenia", contrasenia);
		model.addAttribute("usuario", usuario);
		return "Cliente/vistaInicioCliente";
	}

	@GetMapping("/vehiculo/buscar")
	public String buscarTodos(Model modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarTodos();
		modelo.addAttribute("vehiculos", lista);
		System.out.println("Buscados!");
		return "Cliente/vistaListaVehiculosClientes";
	}

	@GetMapping("/vehiculo/buscarFiltrados")
	public String buscarPorMarcaModelo(Model model, @Param("marca") String marca, @Param("modelo") String modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarPorMarca(marca);
		model.addAttribute("vehiculos", lista);
		model.addAttribute("marca", marca);
		model.addAttribute("modelo", modelo);
		System.out.println("Listo!");
		return "Cliente/vistaListaVehiculosClientes";
	}

	@PostMapping("/vehiculo/reservar")
	public String insertarReservacion(Reservacion reservacion) {
		this.reservacionService.insertarReservacionPl(reservacion);
		return "Cliente/vistaDatosPago";

	}

	@GetMapping("/reservacion/reservar")
	public String registroCliente(Reservacion reservacion) {
		return "Cliente/vistaNuevaReserva";
		// return "Cliente/vistaInicioCliente";
	}

	@PostMapping("/reservacion/insertar")
	public String insertarReservacion(Reservacion reservacion,  
			@Param("placa") String placa,  
			@Param("cedula") String cedula,  
			@Param("fechaInicio") LocalDateTime fechaInicio,  
			@Param("fechaFin") LocalDateTime  fechaFin,
			Model model) {//Model puede que no haga falta
		System.out.println("Placa: "+placa);
		System.out.println("Placa: "+cedula);
		Boolean disp=this.reservacionService.verificarDisponibilidad(placa, fechaInicio, fechaFin);
		
		//this.reservacionService.reservar(placa, cedula, fechaInicio, fechaFin);
		System.out.println("DISPONIVLIDIDAD: "+disp);
		if (disp) {
			
			reservacion.setCedula(cedula);
			reservacion.setPlaca(placa);
			reservacion.setFechaInicio(fechaInicio);
			reservacion.setFechaFin(fechaFin);
			model.addAttribute("reservacion1",reservacion);
			return "Cliente/vistaPago";
		}
		
		return "Cliente/vistaListaVehiculosClientes";
		
	}

	@PostMapping("/reservacion/pago")
	public String pagoReservacion(Cobro cobro,
			Reservacion reservac, 
			@Param("targeta") String targeta,
			@Param("placa") String placa,
			@Param("cedula") String cedula,
			@Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin) {
		//NECESITO insertar reservacion y cobro
		//
		//this.cobroService.insertarCobro(targeta, null, null, null)
		
		Reservacion reservacionIns=new Reservacion();
		reservacionIns.setPlaca(placa);
		reservacionIns.setCedula(cedula);
		reservacionIns.setEstado("R");
		reservacionIns.setFechaFin(fechaFin);
		reservacionIns.setFechaInicio(fechaInicio);
		Cliente clienteEncontrado=this.clienteService.buscar(cedula);
		reservacionIns.setCliente(clienteEncontrado);
		this.reservacionService.insertarReservacionPl(reservacionIns);
		
		Vehiculo vehiculoEncontrado=this.iVehiculoService.buscarPorPlaca(placa);
		
		Cobro cobroIns=new Cobro();
		cobroIns=this.cobroService.insertarCobro(targeta, 
				vehiculoEncontrado.getValorDia(), 
				fechaInicio,
				fechaFin, 
				reservacionIns.getId());
		
		//reservacionIns.setCobro(null);
		
		
		return "Principal/vistaInicio";

	}

	@PostMapping("insertar")
	public String insertarCliente(Cliente cliente) {
		cliente.setRegistro("C");
		this.clienteService.agregar(cliente);
		return "Cliente/vistaInicioCliente";
	}

	@PutMapping("actualizar/{cedula}")
	public String actualizarCliente(@PathVariable("cedula") String cedula, Cliente cliente) {
		cliente.setCedula(cedula);
		this.clienteService.actualizar(cliente);
		System.out.println("Vehiculo actualizado!");
		return "Cliente/vistaInicioCliente";
	}

}
