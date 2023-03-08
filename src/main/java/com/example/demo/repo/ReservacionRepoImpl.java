package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Reservacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		return this.entityMrese.find(Reservacion.class, placa);
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
	public Reservacion buscarReservacionId(Integer id) {
		Reservacion reservacion=this.entityMrese.find(Reservacion.class, id);
		return reservacion;
	}

	@Override
	public List<Reservacion> buscarReservacionPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		Query myQuery=this.entityMrese.createNativeQuery(""
				+ "SELECT * FROM reservacion r "
				+ "where  :datoFechaInicio<=r.rese_fecha_inicio and r.rese_fecha_fin<=:datoFechaFin",Reservacion.class);
		
		myQuery.setParameter("datoFechaInicio", fechaInicio);
		
		myQuery.setParameter("datoFechaFin", fechaFin);
		
		List<Reservacion> myList=myQuery.getResultList();
		return myList;
	}
	
	

}
