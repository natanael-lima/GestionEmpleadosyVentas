package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Customer;
import ar.edu.unju.fi.tpf.model.Product;
import ar.edu.unju.fi.tpf.repository.ICustomerRepository;
import ar.edu.unju.fi.tpf.service.ICustomerService;

@Service
public class CustomerServiceRepositoryImp implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepo;
	
	@Override
	public void guardarCliente(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
	}

	@Override
	public List<Customer> obtenerClientes() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public void eliminarCliente(Long customerNumber) {
		// TODO Auto-generated method stub
		 customerRepo.deleteById(customerNumber);
	}

	@Override
	public Customer buscarCliente(Long customerNumber) {
		// TODO Auto-generated method stub
		return customerRepo.findById(customerNumber).orElse(null);
	}

}
