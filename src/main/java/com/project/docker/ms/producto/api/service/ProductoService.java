package com.project.docker.ms.producto.api.service;

import java.util.List;
import java.util.Optional;

import com.project.docker.ms.producto.api.model.Producto;

public interface ProductoService {
	
	List<Producto> listar();
	
	Optional<Producto> obtenerPorId(String id);
	
	Producto grabar(Producto producto);
	
	void eliminar(String id);
	
}