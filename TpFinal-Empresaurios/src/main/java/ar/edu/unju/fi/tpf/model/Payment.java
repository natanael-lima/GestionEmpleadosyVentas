package ar.edu.unju.fi.tpf.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name="payments")
@Component
public class Payment implements Serializable{
	@EmbeddedId
    private PaymentID checkNumber;
	
	@Column(name="pay_Date")
	private LocalDateTime paymentDate;
	
	@Column(name="pay_amount")
	private long amount;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(PaymentID checkNumber, LocalDateTime paymentDate, long amount) {
		super();
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public PaymentID getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(PaymentID checkNumber) {
		this.checkNumber = checkNumber;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	
	
	
}
