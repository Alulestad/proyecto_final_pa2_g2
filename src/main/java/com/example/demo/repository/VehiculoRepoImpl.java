package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
	@Transactional
	public class VehiculoRepoImpl implements IVehiculoRepository {
		@PersistenceContext
		private EntityManager entityManager;

		@Override
		public void insertar(Vehiculo vehiculo) {
			// TODO Auto-generated method stub
			this.entityManager.persist(vehiculo);
		}

		@Override
		public Vehiculo buscarPlaca(String placa) {
			// TODO Auto-generated method stub
			TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=:datoPlaca",
					Vehiculo.class);
			query.setParameter("datoPlaca", placa);
			return query.getSingleResult();
		}

		@Override
		public List<Vehiculo> buscarMarca(String marca) {
			// TODO Auto-generated method stub
			TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca=:datoMarca",
					Vehiculo.class);
			query.setParameter("datoMarca", marca);
			return query.getResultList();
		}

		@Override
		public void actualizar(Vehiculo vehiculo) {
			// TODO Auto-generated method stub
			this.entityManager.merge(vehiculo);
		}

		@Override
		public void eliminar(String placa) {
			// TODO Auto-generated method stub
			this.entityManager.remove(this.buscarPlaca(placa));
		}

		@Override
		public List<Vehiculo> buscarTodos() {
			// TODO Auto-generated method stub
			TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
			List<Vehiculo> lista = query.getResultList();
			lista.forEach(v -> {
				if (v.getReservas() != null) {
					v.getReservas().size();
				}
			});
			return lista;
		}

	}


