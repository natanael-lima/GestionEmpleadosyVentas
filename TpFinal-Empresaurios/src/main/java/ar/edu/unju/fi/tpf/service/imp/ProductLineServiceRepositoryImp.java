package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.ProductLine;
import ar.edu.unju.fi.tpf.repository.IProductLineRepository;
import ar.edu.unju.fi.tpf.service.IProductLineService;

@Service
public class ProductLineServiceRepositoryImp implements IProductLineService{
	
	@Autowired
	IProductLineRepository prodLineRepo;

	@Override
	public List<ProductLine> obtenerProductLines() {
		return (List<ProductLine>) prodLineRepo.findAll();
	}

	@Override
	public void eliminarProd(Long productLineId) {
		prodLineRepo.deleteById(productLineId);
	}

	@Override
	public ProductLine buscarProduct(Long productLineId) {
		return prodLineRepo.findById(productLineId).orElse(null);
	}

}
