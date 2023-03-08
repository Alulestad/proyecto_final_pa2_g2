package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public void actualizarPorBusquedaDeCedula(Cliente cliente) {
		Cliente encontrado=this.buscarPorCedula(cliente.getCedula());
		cliente.setId(encontrado.getId());
		this.entityManager.merge(cliente);
	}

	// Registro 1c (Cliente)
	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myTypedQuery = this.entityManager
				.createQuery("select c from Cliente c " + "where c.cedula = :datoCedula", Cliente.class);
		myTypedQuery.setParameter("datoCedula", cedula);

		return myTypedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Cliente cliente = this.buscarPorCedula(cedula);
		this.entityManager.remove(cliente);
	}

	@Override
	public Cliente buscarPorUsuario_contrasenia(String usuario, String contrasenia) {

		TypedQuery<Cliente> query = this.entityManager.createQuery(
				"select c from Cliente c " + "where c.usuario=:datoUsuario and c.contrasenia=:datoContasenia",
				Cliente.class);
		query.setParameter("datoUsuario", usuario);
		query.setParameter("datoContasenia", contrasenia);

		return query.getSingleResult();
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		TypedQuery<Cliente> typedQuery = this.entityManager
				.createQuery("select c from Cliente c " + "where c.apellido=:datoApellido", Cliente.class);

		typedQuery.setParameter("datoApellido", apellido);

		return typedQuery.getResultList();
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = this.entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);

		List<Cliente> lista = query.getResultList();
		lista.forEach(c -> c.getReservaciones().size());
		return lista;
	}

}
