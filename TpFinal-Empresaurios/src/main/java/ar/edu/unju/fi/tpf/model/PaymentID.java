package ar.edu.unju.fi.tpf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PaymentID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cust_number")
	private Customer customerNumber;
	
	
	
	@Column(name="pay_number")
	private long checkNumber;
    
	
	
	
	public PaymentID() {
		super();
	}




	public PaymentID(Customer customerNumber) {
		super();
		this.customerNumber = customerNumber;
		
	}




	public Customer getCustomerNumber() {
		return customerNumber;
	}




	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public void setCheckNumber(long checkNumber) {
		this.checkNumber=checkNumber;
	}



	public long getCheckNumber() {
		return checkNumber;
	}




	





	


	




	
	
	
	
}
