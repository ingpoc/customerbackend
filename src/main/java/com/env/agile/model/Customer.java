package com.env.agile.model;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UUID")
	private UUID UUID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "NAME")
	private String Name;
	@Column(name = "SURNAME")
	private String surName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ADDRESS")
	private String address;
	public Customer() {}
	
	
	public UUID getUUID() {
		return UUID;
	}


	public void setUUID(UUID uUID) {
		UUID = uUID;
	}



	public String getName() {
		return Name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getSurName() {
		return surName;
	}
	


	public void setSurName(String surName) {
		this.surName = surName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [UUID=" + UUID + ", ID=" + id + ", Name=" + Name + ", surName=" + surName + ", email=" + email
				+ ", address=" + address + "]";
	}
}