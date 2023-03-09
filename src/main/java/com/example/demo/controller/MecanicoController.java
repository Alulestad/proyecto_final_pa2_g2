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
import com.example.demo.repo.modelo.Mecanico;
import com.example.demo.repo.service.IEmpleadoService;
import com.example.demo.repo.service.IMecanicoService;


@Controller
@RequestMapping("/mecanico")
public class MecanicoController {
	
	@Autowired
	private IMecanicoService mecanicoService;
	
	@GetMapping("")
	public String paginaInicio() {
		return "Empleado/vistainicioEmpleado";
	}
	
	@GetMapping("/registrar")
	public String registrarMecanico(Mecanico mecanico) {
		return "Empleado/vistaEmpleadoInsertar";
	}
	
	@PostMapping("/insertado")
	public String insertarMecanico(Mecanico mecanico) {
		this.mecanicoService.agregarmecanico(mecanico);
		return "redirect:/empleado";
	}
////////////////////////////////////////////////REPORTEVIP//////////
	
////////////////////////////////////////////////REPORTEVIP//////////
	
	
	
//////////////////////////////////////////////CLIENTESVIP//////////
	
	

//////////////////////////////////////////////CLIENTESVIP//////////
	

////////////////////////////////////////////VEHICULOSVIP//////////
	
	
	
}
