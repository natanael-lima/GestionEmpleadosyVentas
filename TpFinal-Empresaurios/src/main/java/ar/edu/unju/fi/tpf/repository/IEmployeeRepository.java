package ar.edu.unju.fi.tpf.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpf.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long>{

}
