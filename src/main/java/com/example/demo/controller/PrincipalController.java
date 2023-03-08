package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Empleado;

@Controller
@RequestMapping("/principal")
public class PrincipalController {
	
	
	@GetMapping("/home")
	public String inicio(Cliente cliente, Empleado empleado){
		return "Principal/vistaInicio";
	}
	@RequestMapping("/clientes/")
	public String paginaCliente() {
		return "";
	}
	

}
