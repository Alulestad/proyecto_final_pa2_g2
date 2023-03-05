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
import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.repo.service.IClienteService;
import com.example.demo.repo.service.IVehiculoService;

@Controller
@RequestMapping("/principal")
public class VehiculoController {
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IClienteService clienteService;
	
	
	@GetMapping("/cliente/iniciar")
	public String inicioPrograma(Cliente cliente){
		
		return "vistaPrincipal";
	}
	
	@GetMapping("/cliente/buscarInicio")
	public String validarPersona(Cliente cliente) {
		
		Cliente clienteG =this.clienteService.buscarPorUsuario_contrasenia(cliente.getUsuario(), cliente.getContrasenia());
		if (clienteG !=null) {
			if(clienteG.getTipo().equals("E")) {
				System.out.println("Empleado CLiente: "+cliente);
				//return "vistaEmpleado";
			}else {
				System.out.println("Cliente CLiente: "+cliente);
				//return "vistaCliente";
			}
			
		}
		System.out.println("null");
		return "vistaPrincipal";
	}
	
	@PostMapping("/cliente/insertarVentana")
	public String insertarClienteVentana(Cliente cliente) {

		return "vistaRegistro";
	}
	
	@PostMapping("/cliente/insertar")
	public String insertarCliente(Cliente cliente) {
		cliente.setRegistro("C");
		this.clienteService.agregar(cliente);
		
		
		return "vistaPrincipal";//retorneme a mi misma vista
	}

	// GET
	@GetMapping("/vehiculos/buscar")
	public String buscarTodos(Model modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarTodos();
		modelo.addAttribute("vehiculos", lista);
		return "vistaListaVehiculosEmpleados";
	}
	
	@GetMapping("/vehiculos/buscarFiltrados")
	public String buscarPorMarca(Model modelo, @Param("marca") String marca) {
		List<Vehiculo> lista = this.iVehiculoService.buscarPorMarca(marca);
		modelo.addAttribute("vehiculos", lista);
		modelo.addAttribute("marca", marca);
		System.out.println("Listo!");
		return "vistaListaVehiculosEmpleados";
	}
	
	//El id del vehiculo es su placa
	@GetMapping("/vehiculos/buscarUno/{placaVehiculo}")
	public String buscarVehiculo(@PathVariable("placaVehiculo") String placa, Model modelo) {
		System.out.println("El ID:" + placa);
		Vehiculo vehi = this.iVehiculoService.buscarPorPlaca(placa);
		modelo.addAttribute("vehiculo", vehi);
		return "vistaVehiculoActualizar";
	}

	@PutMapping("/vehiculos/actualizar/{placaVehiculo}")
	public String actualizarVehiculo(@PathVariable("placaVehiculo") String placa, Vehiculo vehiculo) {
		vehiculo.setPlaca(placa);
		this.iVehiculoService.actualizar(vehiculo);
		System.out.println("Vehiculo actualizado!");
		return "redirect:/vehiculos/buscar";
	}

	@DeleteMapping("/vehiculos/borrar/{placaVehiculo}")
	public String borrarVehiculo(@PathVariable("placaVehiculo") String placa) {
		this.iVehiculoService.eliminar(placa);
		return "redirect:/vehiculos/buscar";
	}

	@PostMapping("/vehiculos/insertar")
	public String insertarVehiculo(Vehiculo vehiculo) {
		this.iVehiculoService.insertar(vehiculo);
		return "redirect:/vehiculos/buscar";
	}
	@GetMapping("/vehiculos/visualizar/{placaVehiculo}")
	public String visualizar(@PathVariable("placaVehiculo") String placa, Model modelo) {
		System.out.println("El ID:" + placa);
		Vehiculo vehi = this.iVehiculoService.buscarPorPlaca(placa);
		modelo.addAttribute("vehiculo", vehi);
		return "vistaVehiculo";
	}

	// Metodos de redireccionamientos a paginas
	@GetMapping("/vehiculos/nuevoVehiculo")
	public String paginaNuevoVehiculo(Vehiculo vehiculo) {
		return "vistaNuevoVehiculoEmpleados";
		
	}
}
