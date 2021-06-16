package ar.edu.unju.fi.tpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/form/product")
	public String getFormProd(Model model) {
		model.addAttribute(product);
		model.addAttribute("productLines", prodLineService.obtenerProductLines());
		return "form-producto";
	}
	
	@GetMapping("/tablaprod")
	public String getTablaprod(Model model) {
		
		model.addAttribute("productos", prodService.obtenerProducts());
		
		return "tablaProduct";
	}
	
	@PostMapping("/form/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		
			ModelAndView model;
			
			
			ProductLine prodLine = prodLineService.buscarProduct(product.getProductLine().getProductLineId());
			product.setProductLine(prodLine);
			 
			prodService.guardarProduct(product);
			model= new ModelAndView("tablaProduct");
			model.addObject("productos", prodService.obtenerProducts());
			return model;
	}
		
	
	/*
	 * @PostMapping("/form/saveproduct") public ModelAndView
	 * getsaveProduct(@Valid @ModelAttribute("product") Product product,
	 * BindingResult result) { ModelAndView model; if(result.hasErrors()) { model=
	 * new ModelAndView("form-producto"); model.addObject(product); return model; }
	 * else { prodRepo.save(product); model= new ModelAndView("tablaProduct");
	 * model.addObject("productos", prodRepo.findAll());
	 * System.out.println("SE GUARDO CORRECTAMENTE"); return model; }
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping("/form/eliminar/{id}") public ModelAndView
	 * getEliminarProduct(@PathVariable(value = "id") String param) { ModelAndView
	 * model = new ModelAndView("tablaProduct"); prodRepo.deleteById(param);
	 * model.addObject("productos", prodRepo.findAll()); return model; }
	 * 
	 * @GetMapping("/form/modificar/{id}") public ModelAndView
	 * getModificarProduct(@PathVariable(value = "id") String param) { ModelAndView
	 * model = new ModelAndView("tablaProduct"); Optional<Product> product =
	 * prodRepo.findById(param); model.addObject("product", product); return model;
	 * }
	 */
		
}
