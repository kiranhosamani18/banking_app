package Dto;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Bankaccounts {
	
	@Id
	@GeneratedValue(generator = "acc_no")
	@SequenceGenerator(initialValue = 45678123, allocationSize = 1, sequenceName = "acc_no", name = "acc_no")
	long acc_no;       //auto
	String bank_type;
	double amount;
	double acc_limit;
	boolean status;
	
	
	@ManyToOne
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)  //we can easily persist or save the code in a single line
	
	List<Bank_Transaction> bank_Transactions;

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAcc_limit() {
		return acc_limit;
	}

	public void setAcc_limit(double acc_limit) {
		this.acc_limit = acc_limit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Bank_Transaction> getBank_Transactions() {
		return bank_Transactions;
	}

	public void setBank_Transactions(List<Bank_Transaction> bank_Transactions) {
		this.bank_Transactions = bank_Transactions;
	}
}
