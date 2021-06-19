package ar.edu.unju.fi.tpf.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetailId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prod_code")
	private Product productCode;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ord_number")
	private Order orderNumber;

	
	
	public OrderDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}



	public OrderDetailId(Product productCode, Order orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}



	public Product getProductCode() {
		return productCode;
	}



	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}



	public Order getOrderNumber() {
		return orderNumber;
	}



	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	
	
	
	

}
