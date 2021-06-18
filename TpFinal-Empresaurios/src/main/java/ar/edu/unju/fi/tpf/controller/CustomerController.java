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

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.service.ICustomerService;

@Controller
public class CustomerController {

	@Autowired
	Customer customer;
	
	@Autowired
	ICustomerService customerService;

	//============================ Metodo para ingresar al formulario ============================
	@GetMapping("/form/customer")
	public String getFormCust(Model model) {
		model.addAttribute(customer);
		return "form-cliente";
	}
	//============================ Metodo para mostrar la tabla  ============================
	@GetMapping("/tablacustomer")
	public String getTablaCustomer(Model model) {
		
		model.addAttribute("clientes", customerService.obtenerClientes());
		
		return "tablaCustomer";
	}
	//============================ Metodo para enviar datos a traves del formulario ============================
	@PostMapping("/form/savecustomer")
	public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		
			ModelAndView model;
			if(result.hasErrors()) {
				
				model= new ModelAndView("form-cliente");
				model.addObject(customer);
				
				return model;
			}	
			
			customerService.guardarCliente(customer);
			model= new ModelAndView("tablaCustomer");
			model.addObject("clientes",customerService.obtenerClientes());
			return model;
	}
	
	//============================ Metodo para eliminar ============================
	  @GetMapping("/form/eliminarCustomer/{id}") 
	  public ModelAndView getEliminarOffice(@PathVariable(value = "id") long param) { 
		  
	  ModelAndView model = new ModelAndView("tablaCustomer");
	  customerService.eliminarCliente(param);
	  model.addObject("offices", customerService.obtenerClientes()); 
	  return model; 
	  }
	  
	//============================ Metodo para editar ============================  
	  @GetMapping("/form/modificarCustomer/{id}") 
	  public ModelAndView getModificarOffice(@PathVariable(value = "id") long param) 
	  { 
		  ModelAndView model = new ModelAndView("form-cliente");
		  Customer customer = customerService.buscarCliente(param);
		  model.addObject("customer",customer);

		  return model;
	  }
	
}
