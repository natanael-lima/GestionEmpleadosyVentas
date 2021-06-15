package ar.edu.unju.fi.tpf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@Column(name= "ordD_id")
	private OrderDetailId orderId;
	
	@Column(name="ordD_quantity")
	private int quantityOrdered;
	
	@Column(name="ordD_price")
	private double priceEach;
	
	@Column(name="ordD_lineNumber")
	private int orderLineNumber;
	
	
	
	
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetailId getOrderId() {
		return orderId;
	}



	public void setOrderId(OrderDetailId orderId) {
		this.orderId = orderId;
	}



	public long getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
	public double getPriceEach() {
		return priceEach;
	}
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}
	
	public long getOrderLineNumber() {
		return orderLineNumber;
	}
	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	
	
}
