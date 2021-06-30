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
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.model.Employee;
import ar.edu.unju.fi.tpf.model.ListProducts;
import ar.edu.unju.fi.tpf.model.Order;
import ar.edu.unju.fi.tpf.model.OrderDetail;
import ar.edu.unju.fi.tpf.model.OrderDetailId;
import ar.edu.unju.fi.tpf.model.Payment;
import ar.edu.unju.fi.tpf.model.Product;
import ar.edu.unju.fi.tpf.service.ICustomerService;
import ar.edu.unju.fi.tpf.service.IEmployeeService;
import ar.edu.unju.fi.tpf.service.IOrderDetailService;
import ar.edu.unju.fi.tpf.service.IOrderService;
import ar.edu.unju.fi.tpf.service.IProductService;

@Controller
public class OrderDetailController {
	@Autowired
	OrderDetail orderDetail;
	@Autowired
	Order order;
	@Autowired
	Payment payment;
	
	@Autowired
	ListProducts lista;
	
	@Autowired
	IOrderDetailService orderDetailService;
	
	@Autowired
	ICustomerService customerService;
	   
	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IOrderService orderService;
	
	//Formulario OrderDetail
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/form/orderDetail")
	public String getOrderDetailPage(Model model) {
		model.addAttribute(orderDetail);
		model.addAttribute(order);
		model.addAttribute("lista",lista);
		//mandar solament los clientes que estan activos
		List<Customer> clientes= new ArrayList<Customer>();
		for(Customer cli: customerService.obtenerClientes()) {
			if(cli.getState()!=false)
				clientes.add(cli);
		}
		model.addAttribute("customers", clientes);
		model.addAttribute("employees",employeeService.obtenerEmployees());
		model.addAttribute("products",productService.obtenerProducts());
		return "form-orderDetail";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/form/saveOrderDetail")
	public String getOrderDetailPage(@ModelAttribute("orderDetail") OrderDetail orderDetail,@Valid  @ModelAttribute("order") Order order,BindingResult result,@ModelAttribute("lista") ListProducts lista,Model model) {
		double amount=0;
		
		
		if(result.hasErrors()) {
			System.out.println("Entra?");
			model.addAttribute(orderDetail);
			model.addAttribute(order);
			model.addAttribute("lista",lista);
			//mandar solament los clientes que estan activos
			List<Customer> clientes= new ArrayList<Customer>();
			for(Customer cli: customerService.obtenerClientes()) {
				if(cli.getState()!=false)
					clientes.add(cli);
			}
			model.addAttribute("customers", clientes);
			model.addAttribute("employees",employeeService.obtenerEmployees());
			model.addAttribute("products",productService.obtenerProducts());
			
			
			return "form-orderDetail";
		}
		System.out.println("No entra?");
		orderService.guardarOrder(order);
		//guardar orderDetails segun los productos seleccionados
		for(Product prod: lista.getProducts()) {
			orderDetail.setOrderId(new OrderDetailId(prod,order));
		      
			orderDetail.setPriceEach(orderDetail.getOrderId().getProductCode().getBuyPrice());  
			
			amount=amount+orderDetail.getPriceEach()*orderDetail.getQuantityOrdered();
			orderDetailService.guardarOrderDetail(orderDetail);
			
		}
		
		//Setear empleado al cliente que nos atendio
		
		   Employee employee = employeeService.buscarEmployee(orderDetail.getOrderId().getOrderNumber().getCustomerNumber().getEmployee().getEmployeeNumber());
		   Customer customer= customerService.buscarCliente(orderDetail.getOrderId().getOrderNumber().getCustomerNumber().getCustomerNumber());
		
		  customer.setEmployee(employee);
		  customerService.guardarCliente(customer);
		   
	   
		
		
		
		model.addAttribute(payment);
		
		model.addAttribute("amount",amount);
		model.addAttribute("customer",orderDetail.getOrderId().getOrderNumber().getCustomerNumber());
		return "form-payment";
	}
	@GetMapping("/tablaOrderDetail")
	public String getTablaOrderDetail(Model model) {
		model.addAttribute("orderDetails",orderDetailService.obtenerOrderDetails());
		return "tablaOrderDetail";
	}
}
