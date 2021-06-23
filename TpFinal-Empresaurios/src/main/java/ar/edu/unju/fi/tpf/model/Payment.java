package ar.edu.unju.fi.tpf.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="payments")
@Component
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private PaymentID paymentID;
	
	
	
	@Column(name="pay_Date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@Column(name="pay_amount")
	private double amount;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(PaymentID paymentID, LocalDate paymentDate, double amount) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public PaymentID getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(PaymentID paymentID) {
		this.paymentID = paymentID;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	


	
	
	
}
