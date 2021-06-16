package ar.edu.unju.fi.tpf.service;

import java.util.List;
import ar.edu.unju.fi.tpf.model.ProductLine;

public interface IProductLineService {
	
	public List<ProductLine> obtenerProductLines();
	
	public void eliminarProd(Long productLineId);
	
	public ProductLine buscarProduct(Long productLineId);
	
}
