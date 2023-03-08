package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menus")
public class MenuController {

	@GetMapping("")
	public String menuPrincipal() {
		return "menuInicio";
	}

	@GetMapping("/empleado")
	public String menuEmpleado() {
		return "vistamenuEmpleado";
	}

}
