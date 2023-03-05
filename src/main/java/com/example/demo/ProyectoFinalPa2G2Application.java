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
	private IReservacionService iReservacionServicePL;
	
	private static final Logger LOG=LoggerFactory.getLogger(ProyectoFinalPa2G2Application.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPa2G2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("Cliente: "+clienteService.buscarPorUsuario_contrasenia("user", "admin"));
		
		List<Cliente> clientes=this.clienteService.buscarPorApellido("Arias");
		
		clientes.forEach(System.out::println);
		
		List<Vehiculo> vehiculos=this.iVehiculoService.buscarPorMarca_y_modelo(null, "modelo1");
		
		vehiculos.forEach(System.out::println);
		
		System.out.println("Vehiculo por placa: "+this.iVehiculoService.buscarPorPlaca("abc-132"));

		
		
		//Reporte R
		
		List<Reservacion>reservaciones = this.iReservacionServicePL.fechaReservas(LocalDateTime.now()  , LocalDateTime.now());
		reservaciones.forEach(System.out::println);
		System.out.println("Reservacion por fecha:"+this.iReservacionServicePL.buscarReservacionPl("abc-132"));
		
		
	}


}
