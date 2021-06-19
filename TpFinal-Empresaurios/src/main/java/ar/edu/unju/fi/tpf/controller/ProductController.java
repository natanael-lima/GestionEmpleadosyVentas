package ar.edu.unju.fi.tpf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpf.model.Product;
import ar.edu.unju.fi.tpf.model.ProductLine;
import ar.edu.unju.fi.tpf.service.IProductLineService;
import ar.edu.unju.fi.tpf.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	Product product;
	
	@Autowired
	IProductLineService prodLineService;
	
	@Autowired
	IProductService prodService;
	
	//============================ Metodo para ingresar al form producto ============================
	@GetMapping("/form/product")
	public String getFormProd(Model model) {
		 Product product = new Product();
		 model.addAttribute("product", product); 
		 List<ProductLine> listProdLines = prodLineService.obtenerProductLines();
		 model.addAttribute("productLines", listProdLines);
		return "form-producto";
	}
	
	//============================ Metodo para mostrar tabla producto ============================
	@GetMapping("/tablaprod")
	public String getTablaprod(Model model) {
		
		model.addAttribute("productos", prodService.obtenerProducts());
		model.addAttribute("productLines", prodLineService.obtenerProductLines());
		return "tablaProduct";
	}
	
	//============================ Metodo para almacenar los datos del form cargado ============================
	@PostMapping("/form/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		
			ModelAndView model;
	
			ProductLine prodLine = prodLineService.buscarProductLine(product.getProductLine().getProductLineId());
			product.setProductLine(prodLine);
			 
			prodService.guardarProduct(product);
			model= new ModelAndView("tablaProduct");
			
			return model;
	}
	
	
	  @GetMapping("/form/eliminarProduct/{id}")
	  public ModelAndView getEliminarProduct(@PathVariable(value = "id") long param) { 
	  ModelAndView model = new ModelAndView("tablaProduct");
	  prodService.eliminarProduct(param);
	  model.addObject("productos", prodService.obtenerProducts()); 
	  return model; }
	  
	  @GetMapping("/form/modificarProduct/{id}") 
	  public ModelAndView getModificarProduct(@PathVariable(value = "id") Long param) {
		  ModelAndView model = new ModelAndView("form-producto");
		  Product product = prodService.buscarProduct(param); 
		  List<ProductLine> listProdLines = prodLineService.obtenerProductLines();
		  model.addObject("product", product); 
		  
		  model.addObject("productLines", listProdLines);
		  return model;
	  }
	 
		
}
