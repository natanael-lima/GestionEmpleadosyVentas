package ar.edu.unju.fi.tpf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


@Entity
@Table(name="offices")
@Component
public class Office {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="off_code")
	private long officeCode;
	
	@NotEmpty(message = "Debes ingresar city")
	@Size(min = 4,max = 50, message="Minimo 3 y Maximo 50 caracteres")
	@Column(name="off_city")
	private String city;
	
	@NotNull(message = "Debes ingresar phone")
	@Min(value=3999999, message="Error")
	@Max(value=5999999, message="Error")
	@Column(name="off_phone")
	private long phone;
	
	@NotEmpty(message = "Debes ingresar address")
	@Column(name="off_addressLine")
	private String addressLine;
	
	@NotEmpty(message = "Debes ingresar state")
	@Column(name="off_state")
	private String state;
	
	@NotEmpty(message = "Debes ingresar country")
	@Column(name="off_country")
	private String country;
	
	@NotNull(message = "Debes ingresar postal")
	@Min(value=999, message="Error")
	@Max(value=9999, message="Error")
	@Column(name="off_postalCode")
	private long postalCode;
	
	//relacion empleado a oficina- mucho a uno
	@OneToMany(mappedBy = "office")
	private List<Employee> employee;
	
	public Office(long officeCode, String city, long phone, String addressLine, String state, String country,
			long postalCode, List<Employee> employee) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine = addressLine;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.employee = employee;
	}
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(long officeCode) {
		this.officeCode = officeCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine="
				+ addressLine + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", employee=" + employee + "]";
	}
	
	
}
