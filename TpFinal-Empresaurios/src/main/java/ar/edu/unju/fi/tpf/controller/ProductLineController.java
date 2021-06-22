package ar.edu.unju.fi.tpf.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpf.model.Product;
import ar.edu.unju.fi.tpf.model.ProductLine;
import ar.edu.unju.fi.tpf.service.IProductLineService;
import ar.edu.unju.fi.tpf.service.IProductService;

@Controller
public class ProductLineController {

	
	@Autowired
	ProductLine productLine;
	
	@Autowired
	 IProductService prodService;
	
	@Autowired
	IProductLineService prodLineService;
	
	
	
	//============================ Metodo para ingresar al form productLine ============================
	@GetMapping("/form/productline")
	public String getFormProdLine(Model model) {
		model.addAttribute(productLine);
		return "form-productLine";
	}
	
	//============================ Metodo para MOSTRAR la tabla productLine ============================
	@GetMapping("/tablaprodline")
	public String getTablaProdLine(Model model) {
		
		model.addAttribute("productosLine",prodLineService.obtenerProductLines());
		
		return "tablaProductLine";
	}
	
	//============================ Metodo para GUARDAR los datos del form cargados ============================
	@PostMapping("/form/saveproductline")
	public ModelAndView saveProductLine(@Valid @ModelAttribute("productLine") ProductLine productLine, BindingResult result, @RequestParam("file") MultipartFile imagen ) {
		
			ModelAndView model;
			
			if(result.hasErrors()){ //Si tiene errores
				model=new ModelAndView("form-productLine");
				return model;
			}
				//No tiene errores 
				
				//***Para recibir la imagen y crear la ruta abs***
				
				if(!imagen.isEmpty()) { 
					Path directorioImagenes = Paths.get("src//main//resources//static/images");
					String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
					// exception para que evite errores
					try { 
						byte[] byteImg = imagen.getBytes();
						Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
						Files.write(rutaCompleta, byteImg);
						productLine.setImage(imagen.getOriginalFilename());
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
				prodLineService.guardarProductLine(productLine);
				model= new ModelAndView("tablaProductLine");
				model.addObject("productosLine", prodLineService.obtenerProductLines());
				return model;
            
	}
	
	
	
	//============================ Metodo para ELIMINAR los datos del form cargado ============================
	@GetMapping("/form/eliminarProdLine/{id}")
	public String getEliminarProdLine(@PathVariable(name="id")long param, Model model) {
		
		List<Product> aux = prodService.obtenerProducts(); // eliminar la relacion product & productline
		for(Product prod: aux){
			if((prod.getProductLine()) !=null) {
				if(prod.getProductLine().getProductLineId() == param ) {
					
					prod.setProductLine(null);	
					prodService.guardarProduct(prod);
				}
			}

		}

		prodLineService.eliminarProductLine(param);
		model.addAttribute("productosLine", prodLineService.obtenerProductLines());
		
		return "tablaProductLine";
	}
	
	
	//============================ Metodo para EDITAR los datos del form cargado ============================
		@GetMapping("/form/editarProdLine/{id}")
		public String getEditarProdLine (@PathVariable(name="id") long param, Model model) {
			
			ProductLine prodLine = prodLineService.buscarProductLine(param);
			model.addAttribute("productLine", prodLine);
			
			return "form-productLine";
		}
	
}
