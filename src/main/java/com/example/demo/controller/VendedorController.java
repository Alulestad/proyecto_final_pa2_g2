package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Vendedor;
import com.example.demo.repo.service.IVendedorService;

@Controller

@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private IVendedorService iVendedorService;
	
	@GetMapping("/insertar_vendedor")
	public String inicioPrograma(Vendedor vendedor){
		
		return "Vendedor/vistaInsertado";
	}
	@PostMapping("insertar_db_vendedor")
	public String insertarVendedor(@Param("nombre") String nombre,@Param("apellido") String apellido, Vendedor vendedor){
		Vendedor vendedor2=new Vendedor();
		vendedor.setApellido(apellido);
		vendedor.setNombre(nombre);
		iVendedorService.insertarPorId(vendedor2);
		
		return "Vendedor/vistaInsertarVendedor";
	}
}
