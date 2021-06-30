package ar.edu.unju.fi.tpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.tpf.model.OrderDetail;
import ar.edu.unju.fi.tpf.model.Payment;
import ar.edu.unju.fi.tpf.service.IOrderDetailService;
import ar.edu.unju.fi.tpf.service.IPaymentService;

@Controller
public class PaymentController {
	@Autowired
	Payment payment;
	
	@Autowired
	IPaymentService paymentService;
	
	@Autowired
	IOrderDetailService orderDetailService; 
	
	@GetMapping("/form/payment")
	public String getPaymentPage(Model model) {
		model.addAttribute(payment);
		OrderDetail orden=orderDetailService.obtenerOrderDetails().get(orderDetailService.obtenerOrderDetails().size()-1);
		model.addAttribute("amount",orden.getPriceEach()*orden.getQuantityOrdered());
		model.addAttribute("customer",orden.getOrderId().getOrderNumber().getCustomerNumber());
		return "form-payment";
	}
	@PostMapping("/form/savePayment")
	public String savePaymentPage(@ModelAttribute("payment") Payment payment,Model model) {
		OrderDetail orden=orderDetailService.obtenerOrderDetails().get(orderDetailService.obtenerOrderDetails().size()-1);
		payment.setAmount(orden.getPriceEach()*orden.getQuantityOrdered());
		
        if(paymentService.obtenerPayments().isEmpty()) {
        	payment.getPaymentID().setCheckNumber(1);
        }else {
        	payment.getPaymentID().setCheckNumber(paymentService.obtenerPayments().get(paymentService.obtenerPayments().size()-1).getPaymentID().getCheckNumber()+1);
        }
		
		
		paymentService.guardarPayment(payment);
		model.addAttribute("payments",paymentService.obtenerPayments());
		return "tablaPayment";
	}
	@GetMapping("/tablaPayment")
	public String getTablaPayment(Model model) {
		
		model.addAttribute("payments",paymentService.obtenerPayments());
		return "tablaPayment";
	}
}