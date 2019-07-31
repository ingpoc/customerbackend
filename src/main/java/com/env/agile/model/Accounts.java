package com.env.agile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Accounts {

	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;
	
	
	@ManyToOne	  
	@JoinColumn(name = "FK_customerId")
	private Customer customer;
	
	@Column(name = "balance")
	private Double balance;

	@Column(name = "productType")
	private String productType;

	@Column(name = "currency")
	private String currency;

	public Accounts() {
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	

	public long getCustomerId() {
		return customer.getId();
	}



	/*
	 * public Customer getCustomer() { return customer; }
	 */

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setCustomerId(Customer customerId) {
		this.customer = customerId;
	}

	/*
	 * public SubMenu(String description, MainMenu mainMenu) { this.description =
	 * description; this.mainMenu = mainMenu; }
	 */
}