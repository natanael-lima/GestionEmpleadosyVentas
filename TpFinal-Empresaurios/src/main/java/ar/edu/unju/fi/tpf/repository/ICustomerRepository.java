package ar.edu.unju.fi.tpf.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpf.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long>{

}
