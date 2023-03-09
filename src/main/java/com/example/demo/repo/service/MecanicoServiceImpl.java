package com.example.demo.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IClienteRepo;
import com.example.demo.repo.IMecanicoRepo;
import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Mecanico;

@Service
public class MecanicoServiceImpl implements IMecanicoService {

	@Autowired
	private IMecanicoRepo mecanicoRepo ;



	@Override
	public void agregarmecanico(Mecanico mecanico) {
		// TODO Auto-generated method stub
		this.mecanicoRepo.insertarmecanico(mecanico);
	}

	

}
