package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Persona;
import com.example.demo.repo.service.IClienteService;
import com.example.demo.repo.service.IEmpleadoService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IEmpleadoService empleadoService;
	
	
	@GetMapping("/nuevoRegistro")//insertar nuevos datos
	public String paginaNuevaPersona(Persona persona) {
		return "registrar";
	}
}
