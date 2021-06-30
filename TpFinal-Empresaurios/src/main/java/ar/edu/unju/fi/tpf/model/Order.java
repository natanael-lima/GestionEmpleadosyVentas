package ar.edu.unju.fi.tpf.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ord_number")
	private long orderNumber;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="ord_date")
	private LocalDate orderDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="ord_requiredDate")
	private LocalDate requiredDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="ord_shippedDate")
	private LocalDate shippedDate;
	
	@Column(name="ord_status")
	private String status;
	
	@Column(name="ord_comments")
	private String comments;
	
	//Relacion orden a cliente - muchos a uno
	@Valid
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cust_number")
	private Customer customerNumber;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order(LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate, String status, String comments,
			Customer customerNumber) {
		super();
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}



	public long getOrderNumber() {
		return orderNumber;
	}



	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}



	public LocalDate getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}



	public LocalDate getRequiredDate() {
		return requiredDate;
	}



	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}



	public LocalDate getShippedDate() {
		return shippedDate;
	}



	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public Customer getCustomerNumber() {
		return customerNumber;
	}



	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	
	
	
}
