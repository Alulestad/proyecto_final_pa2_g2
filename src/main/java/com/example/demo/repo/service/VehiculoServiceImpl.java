package com.example.demo.repo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IVehiculoRepository;
import com.example.demo.repo.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.insertar(vehiculo);
	}

	@Override
	public List<Vehiculo> buscarPorMarca_y_modelo(String marca,String modelo) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.buscarPorMarca_y_modelo(marca,modelo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.eliminar(placa);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.buscarPorPlaca(placa);
	}

	@Override
	public boolean reservar(String placa, String cedula, LocalDateTime inicio, LocalDateTime final_) {
		// Si el vehiculo se encuentra sin reservas ese dia retorno true
		//sie l vehiculo esta reservado esos dias retorno falso
		
		
		
		return false;
	}

}
