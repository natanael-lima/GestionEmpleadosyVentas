package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.repository.ICustomerRepository;
import ar.edu.unju.fi.tpf.service.ICustomerService;

@Service
public class CustomerServiceRepositoryImp implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepo;
	
	@Override
	public void guardarCliente(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public List<Customer> obtenerClientes() {
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public void eliminarCliente(Long customerNumber) {
		 customerRepo.deleteById(customerNumber);
	}

	@Override
	public Customer buscarCliente(Long customerNumber) {
		return customerRepo.findById(customerNumber).orElse(null);
	}

}
