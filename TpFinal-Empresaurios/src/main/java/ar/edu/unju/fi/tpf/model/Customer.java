package ar.edu.unju.fi.tpf.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="customers")
@Component
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_number")
	private long customerNumber;
	
	@NotEmpty(message = "Debes ingresar name")
	@Size(min = 3,max = 50, message="Minimo 3 y Maximo 50 caracteres")
	@Column(name="cust_name")
	private String customerName;
	
	@NotNull(message = "Debes ingresar phone")
	@Min(value=1000000, message="Error")
	@Max(value=1000000000, message="Error")
	@Column(name="cust_phone")
	private long phone;
	
	@NotEmpty(message = "Debes ingresar Address")
	@Column(name="cust_addressLine")
	private String addressLine;
	
	@NotEmpty(message = "Debes ingresar city")
	@Column(name="cust_city")
	private String city;
	
	@NotEmpty(message = "Debes ingresar state")
	@Column(name="cust_state")
	private String state;
	
	@NotNull(message = "Debes ingresar postal")
	@Min(value=1000, message="Error")
	@Max(value=10000, message="Error")
	@Column(name="cust_postalCode")
	private long postalCode;
	
	@NotEmpty(message = "Debes ingresar country")
	@Column(name="cust_country")
	private String country;
	
	//Relacion cliente a empleados- mucho a uno
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "emp_number")
	private Employee employee;
	
	@NotNull(message = "Debes ingresar creditLimit")
	@Min(value=100, message="Error")
	@Max(value=10000000, message="Error")
	@Column(name="cust_creditLimit")
	private long creditLimit;

	
	public Customer() {
		
		// TODO Auto-generated constructor stub
	}

	




	public Customer(long customerNumber,
			@NotEmpty(message = "Debes ingresar name") @Size(min = 3, max = 50, message = "Minimo 3 y Maximo 50 caracteres") String customerName,
			@NotNull(message = "Debes ingresar phone") @Min(value = 1000000, message = "Error") @Max(value = 1000000000, message = "Error") long phone,
			@NotEmpty(message = "Debes ingresar Address") String addressLine,
			@NotEmpty(message = "Debes ingresar city") String city,
			@NotEmpty(message = "Debes ingresar state") String state,
			@NotNull(message = "Debes ingresar postal") @Min(value = 1000, message = "Error") @Max(value = 10000, message = "Error") long postalCode,
			@NotEmpty(message = "Debes ingresar country") String country, Employee employee,
			@NotNull(message = "Debes ingresar creditLimit") @Min(value = 100, message = "Error") @Max(value = 10000000, message = "Error") long creditLimit) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.phone = phone;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.employee = employee;
		this.creditLimit = creditLimit;
	}


	




	public long getCustomerNumber() {
		return customerNumber;
	}






	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}






	public String getCustomerName() {
		return customerName;
	}






	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}






	public long getPhone() {
		return phone;
	}






	public void setPhone(long phone) {
		this.phone = phone;
	}






	public String getAddressLine() {
		return addressLine;
	}






	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}






	public String getCity() {
		return city;
	}






	public void setCity(String city) {
		this.city = city;
	}






	public String getState() {
		return state;
	}






	public void setState(String state) {
		this.state = state;
	}






	public long getPostalCode() {
		return postalCode;
	}






	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}






	public String getCountry() {
		return country;
	}






	public void setCountry(String country) {
		this.country = country;
	}






	public Employee getEmployee() {
		return employee;
	}






	public void setEmployee(Employee employee) {
		this.employee = employee;
	}






	public long getCreditLimit() {
		return creditLimit;
	}






	public void setCreditLimit(long creditLimit) {
		this.creditLimit = creditLimit;
	}






	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", phone=" + phone
				+ ", addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
				+ ", country=" + country + ", employee=" + employee + ", creditLimit=" + creditLimit + "]";
	}
	
	
	
	
}

