package ar.edu.unju.fi.tpf.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpf.model.ProductLine;
import ar.edu.unju.fi.tpf.service.IProductLineService;

@Controller
public class ProductLineController {

	
	@Autowired
	ProductLine productLine;
	
	@Autowired
	IProductLineService prodLineService;
	
	//============================ Metodo para ingresar al form productLine ============================
	@GetMapping("/form/productline")
	public String getFormProdLine(Model model) {
		model.addAttribute(productLine);
		return "form-productLine";
	}
	
	//============================ Metodo para mostrar la tabla productLine ============================
	@GetMapping("/tablaprodline")
	public String getTablaProdLine(Model model) {
		
		model.addAttribute("productosLine",prodLineService.obtenerProductLines() );
		
		return "tablaProductLine";
	}
	
	//============================ Metodo para almacenar los datos del form cargados ============================
	@PostMapping("/form/saveproductline")
	public ModelAndView saveProductLine(@ModelAttribute("productLine") ProductLine productLine, @RequestParam("file") MultipartFile imagen) {
		
			ModelAndView model;
            //***Para recibir la imagen y crear la ruta abs***
			if(!imagen.isEmpty()) {
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				// execption para que evite errores
				try { 
					byte[] byteImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
					Files.write(rutaCompleta, byteImg);
					productLine.setImage(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			prodLineService.guardarProductLine(productLine);;
			model= new ModelAndView("tablaProductLine");
			model.addObject("productosLine", prodLineService.obtenerProductLines());
			return model;
	}
		
}
