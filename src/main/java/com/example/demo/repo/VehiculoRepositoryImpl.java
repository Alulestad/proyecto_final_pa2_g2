package com.example.demo.repo;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Vehiculo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
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

}
