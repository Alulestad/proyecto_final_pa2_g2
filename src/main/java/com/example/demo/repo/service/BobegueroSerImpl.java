package com.example.demo.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IBodegueroRepo;
import com.example.demo.repo.modelo.Bodeguero;

@Service
public class BobegueroSerImpl implements IBodegueroSer{

	@Autowired
	private IBodegueroRepo bodegueroRepo;
	@Override
	public void insertarBodeguero(Bodeguero bodeguero) {
		// TODO Auto-generated method stub
		this.bodegueroRepo.insertarBodeguero(bodeguero);
		
	}
	

}
