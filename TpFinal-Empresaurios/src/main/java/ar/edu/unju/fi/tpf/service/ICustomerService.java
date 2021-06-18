package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.model.Customer;


public interface ICustomerService {
	
    public void guardarCliente (Customer customer);
	
	public List<Customer> obtenerClientes();
	
	public void eliminarCliente(Long customerNumber);
	
	public Customer buscarCliente(Long customerNumber);

}
