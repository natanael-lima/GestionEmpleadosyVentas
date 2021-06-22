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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="employees")
@Component
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_number")
	private long employeeNumber;
	
	//@NotEmpty(message = "Debes ingresar tu apellido")
	//@Size(min = 3,max = 50, message="Minimo 3 y Maximo 50 caracteres")
	@Column(name="emp_lastName")
	private String lastName;
	
	//@NotEmpty(message = "Debes ingresar tu nombre")
	//@Size(min = 3,max = 50, message="Minimo 3 y Maximo 50 caracteres")
	@Column(name="emp_firstName")
	private String firstName;
	
	//@NotEmpty(message = "Debes ingresar tu email")
	//@Size(min = 3,max = 50, message="Minimo 3 y Maximo 50 caracteres")
	@Column(name="emp_email")
	private String email;
	
	//@NotEmpty(message = "Debes ingresar tu titulo")
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

	public Employee(long employeeNumber, String lastName, String firstName, String email, String jobTitle,
			Employee employee, Office office, List<Customer> customers) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.jobTitle = jobTitle;
		this.employee = employee;
		this.office = office;
		this.customers = customers;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", email=" + email + ", jobTitle=" + jobTitle + ", employee=" + employee + ", office=" + office
				+ ", customers=" + customers + "]";
	}
	
	
	
	
}
