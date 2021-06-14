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

import org.springframework.stereotype.Component;

@Entity
@Table(name="customers")
@Component
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_number")
	private long customerNumber;
	
	@Column(name="cust_name")
	private String customerName;
	
	@Column(name="cust_phone")
	private long phone;
	
	@Column(name="cust_addressLine")
	private String addressLine;
	
	@Column(name="cust_city")
	private String city;
	
	@Column(name="cust_state")
	private String state;
	
	@Column(name="cust_postalCode")
	private long postalCode;
	
	@Column(name="cust_country")
	private String country;
	
	//Relacion cleinte a empleados- mucho a uno
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "emp_number")
	private Employee employee;
	
	@Column(name="cust_creditLimit")
	private long creditLimit;
}

