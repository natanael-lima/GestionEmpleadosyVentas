package ar.edu.unju.fi.tpf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="offices")
@Component
public class Office {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="off_code")
	private long officeCode;
	
	@Column(name="off_city")
	private String city;
	
	@Column(name="off_phone")
	private long phone;
	
	@Column(name="off_addressLine")
	private String addressLine;
	
	@Column(name="off_state")
	private String state;
	
	@Column(name="off_country")
	private String country;
	
	@Column(name="off_postalCode")
	private long postalCode;
	//relacion empleado a oficina- mucho a uno
	@OneToMany(mappedBy = "office")
	private List<Employee> employee;
	
}
