package ar.edu.unju.fi.tpf.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		model.addAttribute(product);
		model.addAttribute("productLines", prodLineService.obtenerProductLines());
		return "form-producto";
	}
	
	//============================ Metodo para MOSTRAR tabla producto ============================
	@GetMapping("/tablaprod")
	public String getTablaprod(Model model) {
		
		model.addAttribute("productos", prodService.obtenerProducts());
		
		return "tablaProduct";
	}
	
	//============================ Metodo para GUARDAR los datos del form cargado ============================
	@PostMapping("/form/saveproduct")
	public String saveProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model) {
		
			if(result.hasErrors()) { //Si tiene errores
				
				//model.addAttribute("productLines", prodLineService.obtenerProductLines()); //envia la lista de productLines para el select de la linea de productos
				System.out.println("EXISTIERON ERRORES EN EL FORM");
				return "form-producto";
				
			}
			 	//No tiene errores
				
				/*
				 * ProductLine prodLine = prodLineService.buscarProductLine(product.getProductLine().getProductLineId()); 
				 * product.setProductLine(prodLine);
				 */
				prodService.guardarProduct(product);
				model.addAttribute("productos", prodService.obtenerProducts());
				return "tablaProduct";
	}
		
	//============================ Metodo para ELIMINAR los datos del form cargado ============================
	@GetMapping("/form/eliminarProd/{id}") 
	public ModelAndView getEliminarProduct(@PathVariable(value = "id") long param) { 
		
		 ModelAndView model = new ModelAndView("tablaProduct");
		 prodService.eliminarProduct(param);
		 model.addObject("productos", prodService.obtenerProducts()); 
		 return model; 
	}
	
	
	//============================ Metodo para EDITAR los datos del form cargado ============================
	@GetMapping("/form/editarProd/{id}")
	public String getEditarProduct(@PathVariable (value="id")long param, Model model) {
		
		Product product = prodService.buscarProduct(param); 
		model.addAttribute("product", product);
		
		return "form-producto";
	}
	
}