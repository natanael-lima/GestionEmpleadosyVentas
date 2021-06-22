package ar.edu.unju.fi.tpf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpf.model.Employee;
import ar.edu.unju.fi.tpf.model.Office;
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
	
	//============================ Metodo para ingresar al form empleado ============================
		@GetMapping("/form/employee")
		public String getFormEmp(Model model) {
			model.addAttribute(employee);
			model.addAttribute("employees", employeeService.obtenerEmployees());
			model.addAttribute("office", officeService.obtenerOffice());
			return "form-empleado";
		}
		
	//============================ Metodo para mostrar la tabla employee ============================
		@GetMapping("/tablaemployee")
		public String getTablaEmployee(Model model) {
			
			model.addAttribute("employees",employeeService.obtenerEmployees() );
			model.addAttribute("office",officeService.obtenerOffice() );
			return "tablaEmployee";
		}
		
	//============================ Metodo para almacenar los datos del form cargado ============================
		@PostMapping("/form/saveemployee")
		public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
			    ModelAndView model;
				employeeService.guardarEmployee(employee);
				model= new ModelAndView("tablaEmployee");
				return model;
		}
}
