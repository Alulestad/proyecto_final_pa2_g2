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
public class VehiculoRepoImpl implements IVehiculoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void eliminarVehiculo(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.buscarPlaca(placa);
		this.entityManager.remove(vehiculo);
	}

	@Override
	public List<Vehiculo> consultarVehiculo(String marca) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery(
				"SELECT e FROM Vehiculo e where e.marca = :datoMarca", Vehiculo.class);
		myQuery.setParameter("datoNombre", marca);//1er campo variable a setear segundo parametro con que se va a setear
		List<Vehiculo> lista = myQuery.getResultList();
		return lista;
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

	@Override
	public Vehiculo buscarPlaca(String placa) {
		return this.entityManager.find(Vehiculo.class, placa);
	}

}
