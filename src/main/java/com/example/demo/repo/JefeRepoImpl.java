package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Jefe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Transactional
@Repository
public class JefeRepoImpl implements IJefeRepository{

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void insertarEmpleado(Jefe jefe) {
		// TODO Auto-generated method stub
		this.entityManager.persist(jefe);
	}

}
