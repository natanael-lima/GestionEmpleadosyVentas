package ar.edu.unju.fi.tpf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@Column(name="ord_number")
	private long orderNumber;
	
	@Column(name="ord_date")
	private Date orderDate;
	
	@Column(name="ord_requiredDate")
	private Date requiredDate;
	
	@Column(name="ord_shippedDate")
	private Date shippedDate;
	
	@Column(name="ord_status")
	private String status;
	
	@Column(name="ord_comments")
	private String comments;
	
	//Relacion orden a cliente - muchos a uno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cust_number")
	private Customer customerNumber;

	
	
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
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
