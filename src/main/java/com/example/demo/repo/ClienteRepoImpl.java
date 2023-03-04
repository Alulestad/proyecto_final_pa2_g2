package com.example.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myTypedQuery = this.entityManager.createQuery("select c from Cliente c where c.cedula = :datoCedula", Cliente.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		
		return myTypedQuery.getSingleResult(); 
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Cliente cliente=this.buscarPorCedula(cedula);
				this.entityManager.remove(cliente);
	}

}
