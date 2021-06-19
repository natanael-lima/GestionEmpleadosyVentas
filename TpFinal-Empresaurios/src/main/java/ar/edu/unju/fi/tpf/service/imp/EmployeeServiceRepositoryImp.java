package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Employee;
import ar.edu.unju.fi.tpf.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpf.service.IEmployeeService;

@Service
public class EmployeeServiceRepositoryImp implements IEmployeeService{

	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Override
	public void guardarEmployee(Employee employee) {
	    employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> obtenerEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee buscarEmployee(long employeeNumber) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeNumber).orElse(null);
	}

	@Override
	public void elimarEmployee(long employeeNumber) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeNumber);
	}

}
