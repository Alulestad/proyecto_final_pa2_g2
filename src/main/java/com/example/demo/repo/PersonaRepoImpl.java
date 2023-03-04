package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepoImpl implements IEmpleadoRepo, IClienteRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarClienteId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public Persona buscarClienteCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, cedula);
	}

	@Override
	public void eliminarClienteId(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarClienteId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public void eliminarClienteCedula(String cedula) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarClienteCedula(cedula);
		this.entityManager.remove(persona);
	}

	@Override
	public void insertarCliente(Persona cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizarCliente(Persona cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	///////////////////////////////EMPLEADO/////////////////////////////////////////////////////
	@Override
	public Persona buscarEmpleadoId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public Persona buscarEmpleadoCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, cedula);
	}

	@Override
	public void eliminarEmpleadoId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEmpleadoCedula(String cedula) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarEmpleadoCedula(cedula);
		this.entityManager.remove(persona);
	}

	@Override
	public void insertarEmpleado(Persona empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public void actualizarEmpleado(Persona empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public List<Persona> buscarClientes(String registro) {
		TypedQuery<Persona> myQuery = this.entityManager
				.createQuery("SELECT c FROM Persona c where c.registro = :datoRegistro", Persona.class);
		myQuery.setParameter("datoRegistro", registro);
		List<Persona> lista=myQuery.getResultList();
		return lista;
	}

	@Override
	public List<Persona> buscarEmpleados(String registro) {
		TypedQuery<Persona> myQuery = this.entityManager
				.createQuery("SELECT c FROM Persona c where c.registro = :datoRegistro", Persona.class);
		myQuery.setParameter("datoRegistro", registro);
		List<Persona> lista=myQuery.getResultList();
		return lista;
	}
	
	

}
