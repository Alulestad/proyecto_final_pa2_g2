package com.example.demo.repo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICobroRepo;
import com.example.demo.repo.IReservacionRepo;
import com.example.demo.repo.modelo.Cobro;
import com.example.demo.repo.modelo.Reservacion;

@Service
public class CobroServiceImpl implements ICobroService {

	@Autowired
	private ICobroRepo cobroRepo;
	
	@Autowired
	private IReservacionRepo iReservacionRepo;
	
	@Override
	public Cobro buscarCobroId(Integer id) {
		
		return this.cobroRepo.buscarCobroId(id);
	}

	@Override
	public void eliminarCobroId(Integer id) {
		this.cobroRepo.eliminarCobroId(id);		
	}

	@Override
	public void insertarCobro(Cobro cobro) {
		this.cobroRepo.insertarCobro(cobro);
		
	}

	@Override
	public void actualizarCobro(Cobro cobro) {
		this.cobroRepo.actualizarCobro(cobro);
	}

	@Override
	public void insertarCobro(String targetaCredito, BigDecimal valorDia, Integer numeroDias, Integer idReservacion) {
		Cobro cobro=new Cobro();
		cobro.setFecha(LocalDateTime.now());
		cobro.setTargetaCredito(targetaCredito);
		
		
		BigDecimal valorSubtotal=new BigDecimal(0);
		valorSubtotal=valorSubtotal.add(valorDia);
		valorSubtotal=valorSubtotal.multiply(new BigDecimal(numeroDias.intValue()));
		
		BigDecimal valorIva=valorSubtotal.multiply(new BigDecimal(0.12));
		
		BigDecimal valorTotal=valorSubtotal.add(valorIva);
		
		cobro.setValorIva(valorIva);
		cobro.setValorSubtotal(valorSubtotal);
		cobro.setValorTotal(valorTotal);
		
		
		Reservacion reservacion=this.iReservacionRepo.buscarReservacionPl(targetaCredito);
		cobro.setReservacion(null);
		
		
	}

}
