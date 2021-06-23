package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.model.Payment;

public interface IPaymentService {
	public void guardarPayment(Payment payment);
	
	public List<Payment> obtenerPayments();
}
