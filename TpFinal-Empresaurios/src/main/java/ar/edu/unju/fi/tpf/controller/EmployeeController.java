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

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.model.Employee;
import ar.edu.unju.fi.tpf.service.ICustomerService;
import ar.edu.unju.fi.tpf.service.IEmployeeService;
import ar.edu.unju.fi.tpf.service.IOfficeService;

@Controller
public class EmployeeController {
	
	@Autowired
	Employee employee;
	
	@Autowired
	IOfficeService officeService;
	
	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	ICustomerService customerService;
	
	//============================ Metodo para ingresar al form empleado ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
		@GetMapping("/form/employee")
		public String getFormEmp(Model model) {
			model.addAttribute(employee);
			model.addAttribute("employees", employeeService.obtenerEmployees());
			model.addAttribute("office", officeService.obtenerOffice());
			return "form-empleado";
		}
		
	//============================ Metodo para mostrar la tabla employee ============================
	@Secured({"ROLE_USER","ROLE_ADMIN"})
		@GetMapping("/tablaemployee")
		public String getTablaEmployee(Model model) {
			
			model.addAttribute("employees",employeeService.obtenerEmployees() );
			return "tablaEmployee";
		}
		
	//============================ Metodo para almacenar los datos del form cargado ============================
		@Secured({"ROLE_USER","ROLE_ADMIN"})
		@PostMapping("/form/saveemployee")
		public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,Model model) {
			if(result.hasErrors()) {
				System.out.println("EXISTIERON ERRORES EN EL FORM");
				return "form-empleado";
			}
				employeeService.guardarEmployee(employee);
				model.addAttribute("employeed", employeeService.obtenerEmployees());
				return "index";
		}
	
	//============================ Metodo para EDITAR los datos del form cargado ============================
		@Secured("ROLE_ADMIN")
		@GetMapping("/form/editarEmployee/{id}")
		public String getEditarProduct(@PathVariable (value="id")long param, Model model) {
		    
			model.addAttribute("employee", employeeService.buscarEmployee(param));
			model.addAttribute("office",officeService.obtenerOffice());
			model.addAttribute("employees",employeeService.obtenerEmployees() );
			return "form-empleado";
		}
	
	//============================ Metodo para ELIMINAR los datos del form cargado ============================
		@Secured("ROLE_ADMIN")
		@GetMapping("/form/eliminarEmployee/{id}") 
		public ModelAndView getEliminarProduct(@PathVariable(value = "id") long param) { 
			 
			 ModelAndView model = new ModelAndView("tablaEmployee");
			 
			 //eliminar relacion de empleado a cargo
			 for(Employee emp: employeeService.obtenerEmployees()) {
				 if(emp.getEmployeeId()!=null) {
				 if(emp.getEmployeeId().getEmployeeNumber()==employeeService.buscarEmployee(param).getEmployeeNumber()) {
					 emp.setEmployeeId(null);
					 employeeService.guardarEmployee(emp);
				 }
				 }
			 }
			 //eliminar relacion de cliente con empleado
			 for(Customer cust: customerService.obtenerClientes()) {
				 if(cust.getEmployee().getEmployeeNumber()==param) {
					 cust.setEmployee(null);
					 customerService.guardarCliente(cust);
				 }
			 }
			 employeeService.elimarEmployee(param);
			 model.addObject("employees",employeeService.obtenerEmployees() );
			 return model; 
		}
}
