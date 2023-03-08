package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Cliente;
import com.example.demo.repo.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepoImpl implements IEmpleadoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Empleado buscarEmpleadoId(Integer id) {
		Empleado empleado= this.entityManager.find(Empleado.class, id);
		
		return empleado;
	}

	@Override
	public Empleado buscarEmpleadoCedula(String cedula) {
		TypedQuery<Empleado> query=this.entityManager.createQuery("select e from Empleado e where e.cedula:=datoCedula",Empleado.class);
		query.setParameter("datoCedula",cedula);
		
		
		return query.getSingleResult();
	}

	@Override
	public void eliminarEmpleadoId(Integer id) {
		Empleado empleado= this.entityManager.find(Empleado.class, id);
		
		this.entityManager.remove(empleado);
	}

	@Override
	public void eliminarEmpleadoCedula(String cedula) {
		TypedQuery<Empleado> query=this.entityManager.createQuery("select e from Empleado e where e.cedula:=datoCedula",Empleado.class);
		query.setParameter("datoCedula",cedula);
		
		Empleado empleado=query.getSingleResult();
		this.entityManager.remove(empleado);
	}

	@Override
	public void insertarEmpleado(Empleado empleado) {
		this.entityManager.persist(empleado);

	}

	@Override
	public void actualizarEmpleado(Empleado empleado) {
		
		this.entityManager.merge(empleado);
		
	}

	@Override
	public Empleado buscarPorUsuario_contrasenia(String usuario, String contrasenia) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> query=this.entityManager.createQuery("select e from Empleado e "
				+ "where e.usuario=:datoUsuario and e.contrasenia=:datoContasenia",Empleado.class);
		query.setParameter("datoUsuario", usuario);
		query.setParameter("datoContasenia", contrasenia);
		
		return query.getSingleResult();
	}

}
