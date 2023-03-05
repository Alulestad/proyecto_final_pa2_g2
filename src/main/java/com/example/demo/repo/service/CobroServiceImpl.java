package com.example.demo.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICobroRepo;
import com.example.demo.repo.modelo.Cobro;

@Service
public class CobroServiceImpl implements ICobroService {

	@Autowired
	private ICobroRepo cobroRepo;
	
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

}
