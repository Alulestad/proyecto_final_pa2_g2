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

import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.repo.service.IVehiculoService;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {
	@Autowired
	private IVehiculoService iVehiculoService;

	// GET
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarTodos();
		modelo.addAttribute("vehiculos", lista);
		return "vistaListaVehiculosEmpleados";
	}
	
	@GetMapping("/buscarFiltrados")
	public String buscarPorMarca(Model modelo, @Param("marca") String marca) {
		List<Vehiculo> lista = this.iVehiculoService.buscarPorMarca(marca);
		modelo.addAttribute("vehiculos", lista);
		modelo.addAttribute("marca", marca);
		System.out.println("Listo!");
		return "vistaListaVehiculosEmpleados";
	}
	
	//El id del vehiculo es su placa
	@GetMapping("/buscarUno/{placaVehiculo}")
	public String buscarVehiculo(@PathVariable("placaVehiculo") String placa, Model modelo) {
		System.out.println("El ID:" + placa);
		Vehiculo vehi = this.iVehiculoService.buscarPorPlaca(placa);
		modelo.addAttribute("vehiculo", vehi);
		return "vistaVehiculoActualizar";
	}

	@PutMapping("/actualizar/{placaVehiculo}")
	public String actualizarVehiculo(@PathVariable("placaVehiculo") String placa, Vehiculo vehiculo) {
		vehiculo.setPlaca(placa);
		this.iVehiculoService.actualizar(vehiculo);
		System.out.println("Vehiculo actualizado!");
		return "redirect:/vehiculos/buscar";
	}

	@DeleteMapping("/borrar/{placaVehiculo}")
	public String borrarVehiculo(@PathVariable("placaVehiculo") String placa) {
		this.iVehiculoService.eliminar(placa);
		return "redirect:/vehiculos/buscar";
	}

	@PostMapping("/insertar")
	public String insertarVehiculo(Vehiculo vehiculo) {
		this.iVehiculoService.insertar(vehiculo);
		return "redirect:/vehiculos/buscar";
	}
	@GetMapping("/visualizar/{placaVehiculo}")
	public String visualizar(@PathVariable("placaVehiculo") String placa, Model modelo) {
		System.out.println("El ID:" + placa);
		Vehiculo vehi = this.iVehiculoService.buscarPorPlaca(placa);
		modelo.addAttribute("vehiculo", vehi);
		return "vistaVehiculo";
	}

	// Metodos de redireccionamientos a paginas
	@GetMapping("/nuevoVehiculo")
	public String paginaNuevoVehiculo(Vehiculo vehiculo) {
		return "vistaNuevoVehiculoEmpleados";
		
	}
}
