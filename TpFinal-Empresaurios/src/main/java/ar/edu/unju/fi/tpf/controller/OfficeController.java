package ar.edu.unju.fi.tpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tpf.model.Office;
import ar.edu.unju.fi.tpf.service.IOfficeService;

@Controller
public class OfficeController {
	@Autowired
	Office office;
	
	@Autowired
	IOfficeService officeService;
	
	//============================ Metodo para ingresar al form office ============================
	@GetMapping("/form/office")
	public String getFormOffice(Model model) {
		model.addAttribute(office);
		return "form-office";
	}
	
	//============================ Metodo para mostrar tabla office ============================
	@GetMapping("/tablaoffice")
	public String getTablaOffice(Model model) {
		
		model.addAttribute("offices", officeService.obtenerOffice());
		return "tablaOffice";
	}
	
	//============================ Metodo para almacenar los datos del form cargado ============================
	@PostMapping("/form/saveoffice")
	public ModelAndView saveOffice(@ModelAttribute("office") Office office) {
		
			ModelAndView model;
			officeService.guardarOffice(office);
			model= new ModelAndView("tablaOffice");
			model.addObject("offices", officeService.obtenerOffice());
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
