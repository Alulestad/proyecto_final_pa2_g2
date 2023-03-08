package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public Cliente buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:datoCedula ", Cliente.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}

	@Override
	public List<Cliente> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.apellido=:datoApellido ", Cliente.class);
		query.setParameter("datoApellido", apellido);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = this.entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);

		List<Cliente> lista = query.getResultList();
		lista.forEach(c -> c.getReservas().size());
		return lista;
	}

	@Override
	public void actualizar(Cliente cliente) {
		
		 this.entityManager.merge(cliente);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public void eliminarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarCedula(cedula));
	}

}
