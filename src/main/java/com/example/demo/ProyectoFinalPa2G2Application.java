package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.Cobro;
import com.example.demo.repo.service.ICobroService;

@SpringBootApplication
public class ProyectoFinalPa2G2Application implements CommandLineRunner{
	
	@Autowired
	private ICobroService cobroService;
	
	private static final Logger LOG=LoggerFactory.getLogger(ProyectoFinalPa2G2Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPa2G2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		LOG.info("TEST COBRO");
		Cobro cobro=new Cobro();
		cobro.setFecha(LocalDateTime.now());
		cobro.setTargetaCredito("asdf");
		cobro.setValorIva(new BigDecimal(234));
		cobro.setValorSubtotal(new BigDecimal(23445));
		cobro.setValorTotal(new BigDecimal(234234));
		
		//cobroService.insertarCobro(cobro);
		cobro.setTargetaCredito("aw5/288sdsdf");
		
		//cobroService.actualizarCobro(cobro);
		LOG.info("Cobro 1"+cobroService.buscarCobroId(1));
		cobroService.eliminarCobroId(3);*/
		
		
	}

}
