package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Reservacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Transactional
@Repository
public class ReservacionRepoImpl implements IReservacionRepo {

	
	@PersistenceContext
	private EntityManager entityMrese;
	@Override
	public Reservacion buscarReservacionPl(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Reservacion>myQuery = this.entityMrese.createQuery(
				"Select r from Reservacion r WHERE r.placa=:datoPlaca",Reservacion.class);
		myQuery.setParameter("datoPlaca", placa);
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminarReservacionPl(String placa) {
		// TODO Auto-generated method stub
		Reservacion rese=this.entityMrese.find(Reservacion.class, placa);
		this.entityMrese.remove(rese);
		
	}

	@Override
	public void insertarReservacionPl(Reservacion reservacion) {
		// TODO Auto-generated method stub
		this.entityMrese.persist(reservacion);
		
	}

	@Override
	public void actualizarReservacionPl(Reservacion reservacion) {
		// TODO Auto-generated method stub
		this.entityMrese.merge(reservacion);
		
	}

	@Override
	public List<Reservacion> fechaReservas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		TypedQuery<Reservacion>myQuery = this.entityMrese.createQuery(
			"Select r from Reservacion r WHERE r.fechaInicio>: fecha1 and r.fechaFin<:fecha2",Reservacion.class	);
		myQuery.setParameter("fecha1", fechaInicio);
		myQuery.setParameter("fecha2", fechaFin);
		
		List<Reservacion>fechaReservas = myQuery.getResultList();
		
		return fechaReservas;
	}

}
