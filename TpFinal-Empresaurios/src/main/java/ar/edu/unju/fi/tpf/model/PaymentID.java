package ar.edu.unju.fi.tpf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="cust_number")
	private long customerNumber;
	
    @Column(name="pay_number")
	private long checkNumber;
    
	
	
	
	public PaymentID() {
		super();
	}
	


	public PaymentID(long customerNumber, long checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}




	public long getCustomerNumber() {
		return customerNumber;
	}




	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}




	public long getCheckNumber() {
		return checkNumber;
	}




	public void setCheckNumber(long checkNumber) {
		this.checkNumber = checkNumber;
	}

	
	
	
	
}
