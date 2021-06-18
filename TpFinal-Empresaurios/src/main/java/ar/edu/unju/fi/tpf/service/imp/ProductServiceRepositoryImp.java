package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Product;
import ar.edu.unju.fi.tpf.repository.IProductRepository;
import ar.edu.unju.fi.tpf.service.IProductService;

@Service
public class ProductServiceRepositoryImp implements IProductService{
	
	@Autowired
	IProductRepository productRepo;

	@Override
	public void guardarProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public List<Product> obtenerProducts() {
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public Product buscarProduct(Long productCode) {
		return productRepo.findById(productCode).orElse(null);
	}

	@Override
	public void eliminarProduct(Long productCode) {
		// TODO Auto-generated method stub
		productRepo.deleteById(productCode);
	}

}
