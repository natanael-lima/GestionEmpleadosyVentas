package ar.edu.unju.fi.tpf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	
	

   

	public OrderDetail(OrderDetailId orderId, int quantityOrdered, double priceEach) {
		super();
		this.orderId = orderId;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
	}

	public OrderDetail() {
		super();
	}

	public OrderDetailId getOrderId() {
		return orderId;
	}

	public void setOrderId(OrderDetailId orderId) {
		this.orderId = orderId;
	}

	public int getQuantityOrdered() {
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


	
	
}
