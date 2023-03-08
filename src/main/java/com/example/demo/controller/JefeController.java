package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Jefe;
import com.example.demo.repo.service.IJefeService;

@Controller
@RequestMapping("/jefe")
public class JefeController {

	@Autowired
	private IJefeService iJefeService;
	
	@GetMapping("/registrar")
	public String registrarEmpleado(Jefe jefe) {		
		return "/vistaJefeInsertar";
	}
	
	@PostMapping("/insertado")
	public String insertarPersona(Jefe jefe) {
		this.iJefeService.insertarEmpleado(jefe);
		return "/jefe";
	}
}
