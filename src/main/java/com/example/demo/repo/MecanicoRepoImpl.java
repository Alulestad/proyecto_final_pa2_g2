package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Mecanico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MecanicoRepoImpl implements IMecanicoRepo {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertarmecanico(Mecanico mecanico) {
		// TODO Auto-generated method stub
		this.entityManager.persist(mecanico);
	}

	

}
