package ar.edu.unju.fi.tpf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="employees")
@Component
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_number")
	private long employeeNumber;
	
	@Column(name="emp_lastName")
	private String lastName;
	
	@Column(name="emp_firstName")
	private String firstName;
	
	@Column(name="emp_email")
	private String email;
	
	@Column(name="emp_jobTitle")
	private String jobTitle;
	
	//Relacion de empleado a empleado- mucho a uno
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reports_to")
	private Employee employee;
	
	//Relacion empleado a oficina- mucho a uno
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "off_code")
	private Office office;
	
	//relacion cliente a empleados- mucho a uno
	@OneToMany(mappedBy = "employee")
	private List<Customer> customers;
	
	
}
