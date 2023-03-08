package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Reservacion;
import com.example.demo.repo.modelo.Vehiculo;

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
		System.out.println("RESERVACION: "+reservacion);
		this.entityMrese.persist(reservacion);
		
	}

	@Override
	public boolean verificarReservacionPorCedula_Placa_Fechas(String cedula, String placa,
			LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		Query myQuery=this.entityMrese.createNativeQuery(""
				+ "SELECT * FROM reservacion r "
				+ "where  :fechaInicio<=r.rese_fecha_inicio "
				+ "    and r.rese_fecha_fin<=:fechaFinal)"
				+ "    or (:fechaInicio<=r.rese_fecha_fin"
				+ "        and :fechaInicio>=r.rese_fecha_inicio)"
				+ "    or (:fechaFinal<=r.rese_fecha_fin"
				+ "        and :fechaFinal>=r.rese_fecha_inicio)"
				+ "    or (:fechaInicio>=r.rese_fecha_inicio "
				+ "        and r.rese_fecha_fin>=:fechaFinal)"
				+ "    and r.rese_placa=placa",Reservacion.class);
		
		myQuery.setParameter("fechaInicio", fechaInicio);
		
		myQuery.setParameter("fechaFinal", fechaFinal);
		
		myQuery.setParameter("placa", placa);
		
		List<Reservacion> myList=myQuery.getResultList();
		
		if (myList.size()==0){
			return true;
		}else {
			return false;
		}
		
		
	}

	
	@Override
	public List<Reservacion> listaReservacionPorCedula_Placa_Fechas(String cedula, String placa,
			LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
			Query myQuery=this.entityMrese.createNativeQuery(""
					+ "SELECT * FROM reservacion r "
					+ "where  (:fechaInicio<=r.rese_fecha_inicio "
					+ "    and r.rese_fecha_fin<=:fechaFinal)"
					+ "    or (:fechaInicio<=r.rese_fecha_fin"
					+ "        and :fechaInicio>=r.rese_fecha_inicio)"
					+ "    or (:fechaFinal<=r.rese_fecha_fin"
					+ "        and :fechaFinal>=r.rese_fecha_inicio)"
					+ "    or (:fechaInicio>=r.rese_fecha_inicio "
					+ "        and r.rese_fecha_fin>=:fechaFinal)"
					+ "	   or (date(:fechaInicio)=date(r.rese_fecha_inicio) and "
					+ "			date(:fechaFinal)=date(r.rese_fecha_fin))"
					+ "    and r.rese_placa=:placa",Reservacion.class);
			
			myQuery.setParameter("fechaInicio", fechaInicio);
			
			myQuery.setParameter("fechaFinal", fechaFinal);
			
			myQuery.setParameter("placa", placa);
			
			List<Reservacion> myList=myQuery.getResultList();
			
		return myList;
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
		
		for (Reservacion r:myList) {
			if(r.getVehiculo()!=null){
				r.getCliente().getCedula();
			System.out.println("Cliente SQL: "+r.getCliente().getCedula());
			r.getVehiculo().getPlaca();
			System.out.println("Vehiculo SQL: "+r.getVehiculo().getPlaca());
			}
			
		}
		
		
		return myList;
	}
	
	
	@Override
	public List<Reservacion> buscarPorVehiculo(Vehiculo vehiculo) {
		TypedQuery<Reservacion> query = this.entityMrese
				.createQuery("SELECT r FROM Reservacion r WHERE r.vehiculo=:datoVehiculo", Reservacion.class);
		query.setParameter("datoVehiculo", vehiculo);
		return query.getResultList();
	}

	@Override
	public List<Reservacion> reporte(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
				TypedQuery<Reservacion> query = this.entityMrese.createQuery(
						"SELECT r FROM Reservacion r WHERE r.fechaInicio>=:fechaInicio AND r.fechaFin<=:fechaFin", Reservacion.class);
				query.setParameter("fechaInicio", fechaInicio);
				query.setParameter("fechaFin", fechaFin);

				List<Reservacion> lista = query.getResultList();
				
				
				for (Reservacion r:lista) {
					if(r.getVehiculo()!=null){
					r.getCliente().getCedula();
					System.out.println("Cliente: "+r.getCliente().getCedula());
					r.getVehiculo().getPlaca();
					System.out.println("Vehiculo: "+r.getVehiculo().getPlaca());
					}
				}

				

				return lista;
			}

}
