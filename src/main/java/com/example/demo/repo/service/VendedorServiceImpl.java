package com.example.demo.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IVendedorRepo;
import com.example.demo.repo.modelo.Vendedor;

@Service
public class VendedorServiceImpl implements IVendedorService {

	@Autowired
	private IVendedorRepo iVendedorRepo;
	
	@Override
	public void insertarPorId(Vendedor vendedor) {
		// TODO Auto-generated method stub
		iVendedorRepo.insertarPorId(vendedor);
	}

}
