package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Payment;
import ar.edu.unju.fi.tpf.repository.IPaymentRepository;
import ar.edu.unju.fi.tpf.service.IPaymentService;

@Service
public class PaymentServiceRepositoryImp implements IPaymentService{

	@Autowired
	IPaymentRepository paymentRepository;
	@Override
	public void guardarPayment(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public List<Payment> obtenerPayments() {
		// TODO Auto-generated method stub
		return (List<Payment>)paymentRepository.findAll();
	}

}
