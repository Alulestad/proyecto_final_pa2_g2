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

		CriteriaBuilder criteriaBuilder=this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Vehiculo> criteriaQuery=criteriaBuilder.createQuery(Vehiculo.class);
		
		Root<Vehiculo> root=criteriaQuery.from(Vehiculo.class);
		
		Predicate predicateFinal=null;
		
		Predicate predicate=criteriaBuilder.equal(root.get("marca"), marca);
		Predicate predicate2=criteriaBuilder.equal(root.get("modelo"), modelo);
		
		if(marca!=null & modelo!=null) {
			predicateFinal=criteriaBuilder.and(predicate,predicate2);
		}else {
			predicateFinal=criteriaBuilder.or(predicate,predicate2);
		}
		
		criteriaQuery.select(root).where(predicateFinal);
		
		TypedQuery<Vehiculo> myQuery=this.entityManager.createQuery(criteriaQuery);
		

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
