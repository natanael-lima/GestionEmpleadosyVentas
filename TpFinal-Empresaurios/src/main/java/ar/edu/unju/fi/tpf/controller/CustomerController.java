package ar.edu.unju.fi.tpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
		
			ModelAndView model;
			customerService.guardarCliente(customer);
			model= new ModelAndView("tablaCustomer");
			model.addObject("clientes",customerService.obtenerClientes());
			return model;
	}
	
	
}
