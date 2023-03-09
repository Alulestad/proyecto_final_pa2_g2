package com.example.demo.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IClienteRepo;
import com.example.demo.repo.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepo;


	//Defino en todos los ingresos de cliente que sera
	//de tipo "C"
	@Override
	public void agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizar(cliente);
	}

	@Override

	public void actualizarPorBusquedaDeCedula(Cliente cliente) {
		this.actualizarPorBusquedaDeCedula(cliente);
		
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarPorCedula(cedula);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.clienteRepo.eliminar(cedula);
	}

	@Override
	public Cliente buscarPorUsuario_contrasenia(String usuario, String contrasenia) {
		try {
			return clienteRepo.buscarPorUsuario_contrasenia(usuario, contrasenia);

		}catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarPorApellido(apellido);
	}

}
