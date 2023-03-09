package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.repo.service.IVehiculoService;
import com.example.demo.repo.IReservacionRepo;
import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Cobro;
import com.example.demo.repo.modelo.Reservacion;
import com.example.demo.repo.service.IClienteService;
import com.example.demo.repo.service.ICobroService;
import com.example.demo.repo.service.IReservacionService;


@SpringBootApplication
public class ProyectoFinalPa2G2Application implements CommandLineRunner{
	//public class ProyectoFinalPa2G2Application{
	@Autowired
	private ICobroService cobroService;
	@Autowired 
	private IVehiculoService iVehiculoService;
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IReservacionService iReservacionService;
	
	private static final Logger LOG=LoggerFactory.getLogger(ProyectoFinalPa2G2Application.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPa2G2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
//		
//		LOG.warn("Cliente: "+clienteService.buscarPorUsuario_contrasenia("user", "admin"));
//		LOG.warn("Cliente: "+clienteService.buscarPorUsuario_contrasenia("usr", "admin"));
//		
//		List<Cliente> clientes=this.clienteService.buscarPorApellido("Arias");
//		
//		clientes.forEach(System.out::println);
//		
//		List<Vehiculo> vehiculos=this.iVehiculoService.buscarPorMarca_y_modelo(null, "modelo1");
//		
//		vehiculos.forEach(System.out::println);
//		
//		System.out.println("Vehiculo por placa: "+this.iVehiculoService.buscarPorPlaca("abc-132"));
//		
//		*/
//		
//
//		//this.cobroService.insertarCobro("0987654321", new  BigDecimal(20), 3, 1);
//		Cobro cobro=this.cobroService.buscarCobroId(4);
//		System.out.println(cobro);
//		
//		
//		LocalDateTime fInicio=LocalDateTime.of(2022, 01, 25, 0, 0);
//		LocalDateTime fInicio2=LocalDateTime.of(2023, 03, 9, 0, 0);
//		LocalDateTime fFin=LocalDateTime.of(2024, 01, 25, 0, 0);
//		LocalDateTime fFin2=LocalDateTime.of(2023, 03, 9, 0, 0);
//		
//		List<Reservacion> myList= this.iReservacionService.buscarReservacionPorFecha(fInicio, fFin);
//		myList.forEach(System.out::println);
//		for (Reservacion res:myList) {
//			System.out.println("SQL "+res);
//			//System.out.println("SQL Vehiculo"+res.getVehiculo());
//		}
//		
//		
//		List<Reservacion> myListR=this.iReservacionService.reporte(fInicio, fFin);
//		
//		for (Reservacion res:myListR) {
//			System.out.println("Reservaicon: "+res);
//			System.out.println("vehiculo: "+res.getVehiculo());
//		}
//		
//		
//		Boolean disponibilidad=this.iReservacionService.verificarDisponibilidad("abc-123", fInicio2, fFin2);
//		System.out.println(disponibilidad);
//		
	}


}
