//package ar.edu.unju.fi.tpf.model;
//
//import java.time.LocalDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.springframework.stereotype.Component;
//
//@Entity
//@Table(name="payments")
//@Component
//public class Payment {
//    @Id
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="cust_number")
//	private long customerNumber;
//	
//	@Column(name="pay_Date")
//	private LocalDateTime paymentDate;
//	
//	@Column(name="pay_amount")
//	private long amount;
//	
//	public Payment() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Payment(long customerNumber, LocalDateTime paymentDate, long amount) {
//		super();
//		this.customerNumber = customerNumber;
//		this.paymentDate = paymentDate;
//		this.amount = amount;
//	}
//
//	public long getCustomerNumber() {
//		return customerNumber;
//	}
//
//	public void setCustomerNumber(long customerNumber) {
//		this.customerNumber = customerNumber;
//	}
//
//	public LocalDateTime getPaymentDate() {
//		return paymentDate;
//	}
//
//	public void setPaymentDate(LocalDateTime paymentDate) {
//		this.paymentDate = paymentDate;
//	}
//
//	public long getAmount() {
//		return amount;
//	}
//
//	public void setAmount(long amount) {
//		this.amount = amount;
//	}
//	
//	
//}
