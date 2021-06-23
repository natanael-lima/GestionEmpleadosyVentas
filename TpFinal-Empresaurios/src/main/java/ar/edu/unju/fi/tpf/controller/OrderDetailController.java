package ar.edu.unju.fi.tpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.model.Employee;
import ar.edu.unju.fi.tpf.model.Order;
import ar.edu.unju.fi.tpf.model.OrderDetail;
import ar.edu.unju.fi.tpf.model.Payment;
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
	@GetMapping("/form/orderDetail")
	public String getOrderDetailPage(Model model) {
		model.addAttribute(orderDetail);
		model.addAttribute(order);
	    model.addAttribute("customers",customerService.obtenerClientes());
		model.addAttribute("employees",employeeService.obtenerEmployees());
		model.addAttribute("products",productService.obtenerProducts());
		return "form-orderDetail";
	}
	
	@PostMapping("/form/saveOrderDetail")
	public String getOrderDetailPage(@ModelAttribute("orderDetail") OrderDetail orderDetail,@ModelAttribute("order") Order order,Model model) {
		
		orderService.guardarOrder(order);
		
		orderDetail.getOrderId().setOrderNumber(order);
		//Setear empleado al cliente que nos atendio
		   Employee employee = employeeService.buscarEmployee(orderDetail.getOrderId().getOrderNumber().getCustomerNumber().getEmployee().getEmployeeNumber());
		   Customer customer= customerService.buscarCliente(orderDetail.getOrderId().getOrderNumber().getCustomerNumber().getCustomerNumber());
		
		  customer.setEmployee(employee);
		  customerService.guardarCliente(customer);
		   
		orderDetail.setPriceEach(orderDetail.getOrderId().getProductCode().getBuyPrice());  
		orderDetailService.guardarOrderDetail(orderDetail);
		
		
		model.addAttribute(payment);
		OrderDetail orden=orderDetailService.obtenerOrderDetails().get(orderDetailService.obtenerOrderDetails().size()-1);
		model.addAttribute("amount",orden.getPriceEach()*orden.getQuantityOrdered());
		model.addAttribute("customer",orden.getOrderId().getOrderNumber().getCustomerNumber());
		return "form-payment";
	}
}
