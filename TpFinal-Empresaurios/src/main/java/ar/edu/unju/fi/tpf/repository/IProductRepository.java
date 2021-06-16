package ar.edu.unju.fi.tpf.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpf.model.Product;

public interface IProductRepository extends CrudRepository<Product, Long>{
	
}
