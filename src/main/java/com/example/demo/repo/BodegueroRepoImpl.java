package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Bodeguero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BodegueroRepoImpl implements IBodegueroRepo{

	
	@PersistenceContext
	private EntityManager eM;
	
	@Override
	public void insertarBodeguero(Bodeguero bodeguero) {
		// TODO Auto-generated method stub
		this.eM.persist(bodeguero);
	}
	
	

}
