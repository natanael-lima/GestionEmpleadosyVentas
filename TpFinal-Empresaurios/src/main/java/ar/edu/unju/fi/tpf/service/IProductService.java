package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.model.Product;

public interface IProductService {

	public void guardarProduct (Product product);
	
	public List<Product> obtenerProducts();
	
	public void eliminarProduct(long productCode);
	
	public Product buscarProduct(long productCode);
	
}
