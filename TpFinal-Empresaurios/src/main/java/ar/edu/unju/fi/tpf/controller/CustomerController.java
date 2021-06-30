package ar.edu.unju.fi.tpf.controller;

import java.util.ArrayList;
import java.util.List;

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

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.service.ICustomerService;

@Controller
public class CustomerController {

	@Autowired
	Customer customer;
	
	@Autowired
	ICustomerService customerService;

	//============================ Metodo para ingresar al formulario ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/form/customer")
	public String getFormCust(Model model){
		model.addAttribute(customer);
		return "form-cliente";
	}
	//============================ Metodo para mostrar la tabla  ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/tablacustomer")
	public String getTablaCustomer(Model model) {
		List<Customer> clientes= new ArrayList<Customer>();
		for(Customer cli: customerService.obtenerClientes()) {
			if(cli.getState()!=false)
				clientes.add(cli);
		}
		model.addAttribute("clientes", clientes);
		
		return "tablaCustomer";
	}
	//============================ Metodo para enviar datos a traves del formulario ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/form/savecustomer")
	public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		
			ModelAndView model;
			if(result.hasErrors()) {
				
				model= new ModelAndView("form-cliente");
				model.addObject(customer);
				
				return model;
			}	
			customer.setState(true);
			customerService.guardarCliente(customer);
			model= new ModelAndView("index");
			List<Customer> clientes= new ArrayList<Customer>();
			for(Customer cli: customerService.obtenerClientes()) {
				if(cli.getState()!=false)
					clientes.add(cli);
			}
			model.addObject("clientes",clientes);
			return model;
	}
	
	//============================ Metodo para eliminar ============================
	  @Secured("ROLE_ADMIN")  
	  @GetMapping("/form/eliminarCustomer/{id}") 
	  public ModelAndView getEliminarOffice(@PathVariable(value = "id") long param) { 
	  Customer cliente=customerService.buscarCliente(param);
	  cliente.setState(false);
	  customerService.guardarCliente(cliente);
	  ModelAndView model = new ModelAndView("tablaCustomer");
	  
	  List<Customer> clientes= new ArrayList<Customer>();
		for(Customer cli: customerService.obtenerClientes()) {
			if(cli.getState()!=false)
				clientes.add(cli);
		}
	  model.addObject("clientes", clientes); 
	  return model; 
	  }
	  
	//============================ Metodo para editar ============================  
	  @Secured("ROLE_ADMIN")
	  @GetMapping("/form/modificarCustomer/{id}") 
	  public ModelAndView getModificarOffice(@PathVariable(value = "id") long param) 
	  { 
		  ModelAndView model = new ModelAndView("form-cliente");
		  Customer customer = customerService.buscarCliente(param);
		  model.addObject("customer",customer);

		  return model;
	  }
	
}
