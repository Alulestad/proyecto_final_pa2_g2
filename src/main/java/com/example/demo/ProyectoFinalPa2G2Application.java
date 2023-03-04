package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.repo.service.IVehiculoService;
import com.example.demo.repo.modelo.Cobro;
import com.example.demo.repo.service.ICobroService;


@SpringBootApplication
public class ProyectoFinalPa2G2Application implements CommandLineRunner{
	//public class ProyectoFinalPa2G2Application{
	@Autowired
	private ICobroService cobroService;
	
	private static final Logger LOG=LoggerFactory.getLogger(ProyectoFinalPa2G2Application.class);
	@Autowired 
	private IVehiculoService iVehiculoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPa2G2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Vehiculo vehi1 = new Vehiculo();
		vehi1.setMarca("Toyota");
		vehi1.setPlaca("PCT-1434");
		vehi1.setAño("2015");
		vehi1.setAvaluo(new BigDecimal(10000));
		vehi1.setCilindraje(1.30);
		vehi1.setEstado("D");
		vehi1.setPais("Japón");
		vehi1.setModelo("Prius");
		vehi1.setValorDia(new BigDecimal(40));
		//this.iVehiculoService.insertar(vehi1);
		
		
		Vehiculo vehi2 = new Vehiculo();
		vehi2.setMarca("KIA");
		vehi2.setPlaca("PRG-0423");
		vehi2.setAño("2017");
		vehi2.setAvaluo(new BigDecimal(10000));
		vehi2.setCilindraje(1.20);
		vehi2.setEstado("D");
		vehi2.setPais("Corea del Sur");
		vehi2.setModelo("Sportage");
		vehi2.setValorDia(new BigDecimal(10));
		//this.iVehiculoService.insertar(vehi2);
		
		Vehiculo vehi3 = new Vehiculo();
		vehi3.setMarca("KIA");
		vehi3.setPlaca("PFQ-0445");
		vehi3.setAño("2019");
		vehi3.setAvaluo(new BigDecimal(15000));
		vehi3.setCilindraje(1.30);
		vehi3.setEstado("D");
		vehi3.setPais("Corea del Sur");
		vehi3.setModelo("Sportage");
		vehi3.setValorDia(new BigDecimal(80));
		//this.iVehiculoService.insertar(vehi3);
		
		
		//this.iVehiculoService.buscarPorMarca("KIA");
		
		//this.iVehiculoService.eliminar("PFQ-0445");
		vehi2.setAño("2020");
		//this.iVehiculoService.actualizar(vehi2);
		

		
		
	}


}
