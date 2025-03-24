package com.project.docker.ms.producto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.docker.ms.producto.api.model.Producto;
import com.project.docker.ms.producto.api.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Producto> listarProductos() {
		return productoService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") String id) {
		return productoService.obtenerPorId(id)
				.map(producto -> ResponseEntity.ok(producto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
		Producto nuevoProducto = productoService.grabar(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") String id, @RequestBody Producto productoDetalle) {
		return productoService.obtenerPorId(id)
				.map(producto -> {
					producto.setNombre(productoDetalle.getNombre());
					producto.setDescripcion(productoDetalle.getDescripcion());
					producto.setPrecio(productoDetalle.getPrecio());
					Producto productoActualiza = productoService.grabar(producto);
					return ResponseEntity.ok(productoActualiza);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("id") String id) {
		if (productoService.obtenerPorId(id).isPresent()) {
			productoService.eliminar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}