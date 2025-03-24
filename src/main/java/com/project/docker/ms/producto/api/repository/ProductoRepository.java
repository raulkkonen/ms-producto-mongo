package com.project.docker.ms.producto.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.docker.ms.producto.api.model.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {
	
}
