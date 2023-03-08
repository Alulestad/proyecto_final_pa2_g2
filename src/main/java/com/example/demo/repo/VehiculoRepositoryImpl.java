package com.example.demo.repo;

import java.util.List;



import org.springframework.stereotype.Repository;


import com.example.demo.repo.modelo.Cliente;

import com.example.demo.repo.modelo.Vehiculo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public List<Vehiculo> buscarPorMarca(String marca) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v where v.marca=:datoMarca", Vehiculo.class);
		myQuery.setParameter("datoMarca", marca);
		return myQuery.getResultList();
	
	
	}
	
	@Override
	public List<Vehiculo> buscarPorMarca_y_modelo(String marca,String modelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v where v.marca=:datoMarca AND v.modelo=:datoModelo" , Vehiculo.class);
		myQuery.setParameter("datoMarca", marca);
		myQuery.setParameter("datoModelo", modelo);
		return myQuery.getResultList();
	
	
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehi = this.buscarPorPlaca(placa);
		this.entityManager.remove(vehi);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, placa);
	}

	@Override
	public List<Vehiculo> buscarTodos() {

		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
		return myQuery.getResultList();
	}

}
