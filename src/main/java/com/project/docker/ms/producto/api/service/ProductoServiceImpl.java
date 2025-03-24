package com.project.docker.ms.producto.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.docker.ms.producto.api.model.Producto;
import com.project.docker.ms.producto.api.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	@Override
	public List<Producto> listar() {
		return (List<Producto>)productoRepository.findAll();
	}
	
	@Override
	public Optional<Producto> obtenerPorId(String id) {
		return productoRepository.findById(id);
	}
	
	@Override
	public Producto grabar(Producto producto) {
		return productoRepository.save(producto);
	}
	
	@Override
	public void eliminar(String id) {
		productoRepository.deleteById(id);
	}
	
}