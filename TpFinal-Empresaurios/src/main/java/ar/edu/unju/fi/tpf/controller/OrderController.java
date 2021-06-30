package ar.edu.unju.fi.tpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.model.Employee;
import ar.edu.unju.fi.tpf.model.Order;
import ar.edu.unju.fi.tpf.service.ICustomerService;
import ar.edu.unju.fi.tpf.service.IEmployeeService;
import ar.edu.unju.fi.tpf.service.IOrderService;

@Controller
public class OrderController {
   @Autowired
   IOrderService orderService;
   @Autowired
   Order order;
   
   @Autowired
   ICustomerService customerService;
   
   @Autowired
   IEmployeeService employeeService;
   
   // Formulario de Orden
   @Secured({"ROLE_USER","ROLE_ADMIN"})
   @GetMapping("/form/order")
   public String getFormOrder(Model model) {
	   model.addAttribute(order);
	   model.addAttribute("customers",customerService.obtenerClientes());
	   model.addAttribute("employees",employeeService.obtenerEmployees());
	   return "form-orden";
   }
   
   // Mostrar tabla de ordenes
   @Secured({"ROLE_USER","ROLE_ADMIN"})
   @GetMapping("/tablaOrder")
   public String getTablaOrder(Model model) {
	   model.addAttribute("orders",orderService.obtenerOrders());
	   return "tablaOrder";
   }
   
   // Guardar el formulario Orden
   @Secured({"ROLE_USER","ROLE_ADMIN"})
   @PostMapping("/form/saveOrder")
   public String saveFormOrder(@ModelAttribute("order") Order order,Model model) {
	   orderService.guardarOrder(order);	
	   
	   //Setear empleado al cliente que nos atendio
	   Employee employee = employeeService.buscarEmployee(order.getCustomerNumber().getEmployee().getEmployeeNumber());
	   Customer customer= customerService.buscarCliente(order.getCustomerNumber().getCustomerNumber());
	   customer.setEmployee(employee);
	   customerService.guardarCliente(customer);
	   model.addAttribute("orders",orderService.obtenerOrders());
	   return "tablaOrder";
   }
}
