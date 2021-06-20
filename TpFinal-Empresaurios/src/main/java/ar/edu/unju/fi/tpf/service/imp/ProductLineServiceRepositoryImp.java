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
	public void guardarProductLine(ProductLine productline) {
		prodLineRepo.save(productline);
	}

	@Override
	public List<ProductLine> obtenerProductLines() {
		return (List<ProductLine>) prodLineRepo.findAll();
	}

	@Override
	public void eliminarProductLine(long productLineId) {
		prodLineRepo.deleteById(productLineId);
	}

	@Override
	public ProductLine buscarProductLine(long productLineId) {
		return prodLineRepo.findById(productLineId).orElse(null);
	}

	

	
}
