package com.example.demo.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IUsuarioRepo;
import com.example.demo.repo.modelo.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepo iUsuarioRepo;

	@Override
	public void insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		this.iUsuarioRepo.insertar(usuario);
	}

}
