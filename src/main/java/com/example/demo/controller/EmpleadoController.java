package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Empleado;
import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.repo.service.IClienteService;
import com.example.demo.repo.service.IEmpleadoService;
import com.example.demo.repo.service.IVehiculoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/inicio")
	public String inicioCliente(Empleado empleado) {
		return "Empleado/vistaLogin";
		// return "Cliente/vistaInicioCliente";
	}
	
	@GetMapping("/login")
	public String ingresar(Model model, @Param("contrasenia") String contrasenia, @Param("usuario") String usuario) {
		Empleado user = this.empleadoService.buscarPorUsuario_contrasenia(usuario, contrasenia);
		model.addAttribute("clientes", user);
		model.addAttribute("contrasenia", contrasenia);
		model.addAttribute("usuario", usuario);
		return "Empleado/vistaInicioEmpleado";
	}
	/////////////TODO LO DE CLIENTE/////////////
	@GetMapping("/cliente/nuevo")
	public String clienteNuevo(Cliente cliente) {

		return "Empleado/vistaNuevoCliente";
	}
	///Identificamos que tipo de registro se hizo
	@PostMapping("cliente/insertar")
	public String insertarCliente(Cliente cliente) {
		cliente.setRegistro("E");
		this.clienteService.agregar(cliente);
		return("Empleado/vistaInicioEmpleado");
	}
	
	@GetMapping("/cliente/buscar")
	public String clienteBuscar(Model modelo) {
		
		List<Cliente> lista = this.clienteService.buscarTodos2();
		modelo.addAttribute("clientes", lista);
		System.out.println("Buscados!");
		return "Empleado/vistaLIistaClientes";
	}
	@GetMapping("/cliente/buscarFiltrados")
	public String buscarPorApellido(Model model, @Param("apellido") String apellido) {
		List<Cliente> lista = this.clienteService.buscarPorApellido(apellido);
		model.addAttribute("clientes", lista);
		model.addAttribute("apellido", apellido);
	
		System.out.println("Listo!");
		return "Empleado/vistaListaClientes";
	}
	
	@GetMapping("/cliente/buscarUno/{cedula}")
	public String buscarCliente(@PathVariable("cedula") String cedula, Model modelo) {
		System.out.println("El ID:" + cedula);
		Cliente cliente= this.clienteService.buscar(cedula);
		modelo.addAttribute("cliente", cliente);
		return "Cliente/vistaClienteActualizar";
	}

	@PutMapping("/cliente/actualizar/{cedula}")
	public String actualizarCliente(@PathVariable("cedula") String cedula, Cliente cliente) {
		cliente.setCedula(cedula);
		this.clienteService.actualizar(cliente);
		System.out.println("Cliente actualizado!");
		return "redirect:/cliente/buscar";
	}

	@DeleteMapping("/cliente/borrar/{cedula}")
	public String borrarCliente(@PathVariable("cedula") String cedula) {
		this.clienteService.borrar(cedula);
		return "redirect:/cliente/buscar";
	}
	
	@GetMapping("/cliente/visualizar/{cedula}")
	public String visualizarCliente(@PathVariable("cedula") String cedula, Model modelo) {
		System.out.println("El ID:" +cedula);
		Cliente cli = this.clienteService.buscar(cedula);
		modelo.addAttribute("cliente", cli);
		return "Empleado/vistaCliente";
	}
	
	///////////////TODO LO DE VEHICULO////////////////////
	@GetMapping("/vehiculo/nuevo")
	public String paginaNuevoVehiculo(Vehiculo vehiculo) {
		return "Empleado/vistaNuevoVehiculoEmpleados";
		
	}
	@GetMapping("/vehiculos/buscar")
	public String buscarTodos(Model modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarTodos();
		modelo.addAttribute("vehiculos", lista);
		return "Empleado/vistaListaVehiculosEmpleados";
	}
	
	@PostMapping("/vehiculo/insertar")
	public String insertarVehiculo(Vehiculo vehiculo) {
		this.iVehiculoService.insertar(vehiculo);
		return "redirect:/vehiculos/buscar";
	}
	@GetMapping("/vehiculo/buscarFiltrados")
	public String buscarPorMarcaModelo(Model model, @Param("marca") String marca, @Param("modelo") String modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarPorMarca(marca);
		model.addAttribute("vehiculos", lista);
		model.addAttribute("marca", marca);
		model.addAttribute("modelo", modelo);
		System.out.println("Listo!");
		return "Empleado/vistaListaVehiculosEmpleado";
	}
	//El id del vehiculo es su placa
	@GetMapping("/vehiculo/buscarUno/{placaVehiculo}")
	public String buscarVehiculo(@PathVariable("placaVehiculo") String placa, Model modelo) {
		System.out.println("El ID:" + placa);
		Vehiculo vehi = this.iVehiculoService.buscarPorPlaca(placa);
		modelo.addAttribute("vehiculo", vehi);
		return "vistaVehiculoActualizar";
	}

	@PutMapping("/vehiculo/actualizar/{placaVehiculo}")
	public String actualizarVehiculo(@PathVariable("placaVehiculo") String placa, Vehiculo vehiculo) {
		vehiculo.setPlaca(placa);
		this.iVehiculoService.actualizar(vehiculo);
		System.out.println("Vehiculo actualizado!");
		return "redirect:/vehiculos/buscar";
	}

	@DeleteMapping("/vehiculo/borrar/{placaVehiculo}")
	public String borrarVehiculo(@PathVariable("placaVehiculo") String placa) {
		this.iVehiculoService.eliminar(placa);
		return "redirect:/vehiculos/buscar";
	}

	
	@GetMapping("/vehiculo/visualizar/{placaVehiculo}")
	public String visualizar(@PathVariable("placaVehiculo") String placa, Model modelo) {
		System.out.println("El ID:" + placa);
		Vehiculo vehi = this.iVehiculoService.buscarPorPlaca(placa);
		modelo.addAttribute("vehiculo", vehi);
		return "vistaVehiculo";
	}
	
	

}
