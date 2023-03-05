package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Cobro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CobroRepoImpl implements ICobroRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Cobro buscarCobroId(Integer id) {
		Cobro cobro=this.entityManager.find(Cobro.class, id);
		
		
		return cobro;
	}

	@Override
	public void eliminarCobroId(Integer id) {
		Cobro cobro=this.entityManager.find(Cobro.class, id);
		this.entityManager.remove(cobro);
	}

	@Override
	public void insertarCobro(Cobro cobro) {
		this.entityManager.persist(cobro);

	}

	@Override
	public void actualizarCobro(Cobro cobro) {
		this.entityManager.merge(cobro);
	}

}
