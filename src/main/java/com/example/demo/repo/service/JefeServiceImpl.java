package com.example.demo.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IJefeRepository;
import com.example.demo.repo.modelo.Jefe;

@Service
public class JefeServiceImpl implements IJefeService{

	@Autowired
	private IJefeRepository iJefeRepository;
	
	@Override
	public void insertarEmpleado(Jefe jefe) {
		// TODO Auto-generated method stub
		this.iJefeRepository.insertarEmpleado(jefe);
	}

}
