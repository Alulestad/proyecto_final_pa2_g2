package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Cobro;
import com.example.demo.repo.modelo.Reservacion;
import com.example.demo.repo.modelo.Vehiculo;
import com.example.demo.repo.service.ICobroService;
import com.example.demo.repo.service.IGestorReservasServiceImpl;
import com.example.demo.repo.service.IReservacionService;
import com.example.demo.repo.service.IVehiculoService;

@Controller
@RequestMapping("/reservaciones")
public class ReservacionController {
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IGestorReservasServiceImpl gestorReservasServiceImpl;
	
	@Autowired
	private ICobroService cobroService;
	
	@Autowired
	private IReservacionService iReservacionService;

	@GetMapping("/buscarVehiculoRes")
	public String obtenerPaginaBuscarVehiculo(Reservacion reservacion, Model modelo) {
		modelo.addAttribute("reservacion", reservacion);
		return "vistaBuscarReserva";
	}
	
	@GetMapping("/verificarVehiculo")
	public String verificarVehiculo(Reservacion reservacion, Model modelo) {
		Vehiculo vehiculo=this.iVehiculoService.buscarPorPlaca(reservacion.getVehiculo().getPlaca());
		BigDecimal valorTotal=this.gestorReservasServiceImpl.calculoPagoVehiculo(reservacion.getVehiculo().getPlaca(), reservacion.getFechaInicio(), reservacion.getFechaFin());
		Cobro cobro=new Cobro();
		cobro.setValorTotal(valorTotal);
		reservacion.setCobro(cobro);
		modelo.addAttribute("reservacion",reservacion);
		
		List<Reservacion> reservasVehiculo=vehiculo.getReservaciones();
		if(reservasVehiculo!=null) {
			return "/pagarVehiculo";
		}else {
			return "/pagarVehiculo";
		}
	
	}
	
//	@PutMapping
//	public String pagoReserva(Model modelo,Reservacion reservacion) {
//		Reservacion res=this.iReservacionService.insertarReservacionPl(reservacion);
//		
//		
//	}
	
}
