package ar.edu.unju.fi.tpf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tpf.model.Office;
import ar.edu.unju.fi.tpf.service.IOfficeService;

@Controller
public class OfficeController {
	@Autowired
	private Office office;
	
	@Autowired
	private IOfficeService officeService;
	
	//============================ Metodo para ingresar al form office ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/form/office")
	public String getFormOffice(Model model) {
		model.addAttribute(office);
		return "form-office";
	}
	
	//============================ Metodo para mostrar tabla office ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/tablaoffice")
	public String getTablaOffice(Model model) {
		
		model.addAttribute("offices", officeService.obtenerOffice());
		return "tablaOffice";
	}
	
	//============================ Metodo para almacenar los datos del form cargado ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/form/saveoffice")
	public ModelAndView saveOffice(@Valid @ModelAttribute("office") Office office, BindingResult result) {
		
			ModelAndView model;
			if(result.hasErrors()) {
				
				model= new ModelAndView("form-office");
				model.addObject(office);
				
				return model;
			}	
			
			officeService.guardarOffice(office);
			model= new ModelAndView("tablaOffice");
			model.addObject("offices", officeService.obtenerOffice());
			return model;
	}
	
	//============================ Metodo para eliminar ============================
	@Secured("ROLE_ADMIN")   
	@GetMapping("/form/eliminarOffice/{id}") 
	  public ModelAndView getEliminarOffice(@PathVariable(value = "id") long param) { 
		  
	  ModelAndView model = new ModelAndView("tablaOffice");
	  officeService.eliminarOffice(param);
	  model.addObject("offices", officeService.obtenerOffice()); 
	  return model; 
	  }
	  
	//============================ Metodo para editar ============================  
	@Secured("ROLE_ADMIN")   
	@GetMapping("/form/modificarOffice/{id}") 
	  public ModelAndView getModificarOffice(@PathVariable(value = "id") long param) 
	  { 
		  ModelAndView model = new ModelAndView("form-office");
		  Office office = officeService.buscarOffice(param);
		  model.addObject("office",office);

		  return model;
	  }
	 
		
}
