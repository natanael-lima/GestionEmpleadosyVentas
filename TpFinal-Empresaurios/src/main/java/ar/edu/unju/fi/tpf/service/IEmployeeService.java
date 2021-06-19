package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.model.Employee;

public interface IEmployeeService {
	public void guardarEmployee(Employee employee);
	
	public List<Employee> obtenerEmployees();
	
	public Employee buscarEmployee(long employeeNumber);
	
	public void elimarEmployee(long employeeNumber);
}
