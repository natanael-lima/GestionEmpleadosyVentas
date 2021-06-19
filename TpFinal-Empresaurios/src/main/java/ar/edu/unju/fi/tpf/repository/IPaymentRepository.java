package ar.edu.unju.fi.tpf.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpf.model.Payment;
import ar.edu.unju.fi.tpf.model.PaymentID;

public interface IPaymentRepository extends CrudRepository<Payment, PaymentID>{

}
