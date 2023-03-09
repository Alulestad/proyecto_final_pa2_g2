package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Vendedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Transactional
@Repository
public class VendedorRepoImpl implements IVendedorRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarPorId(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
		entityManager.persist(vendedor);

	}

}
