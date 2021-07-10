package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "customer")
public class Customer implements Serializable { // customer object can covert to stream by serializable interface

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increase
	@Column(nullable = false, updatable = false, unique = true) // column not null and not updated
	private int customerID;

	private String customerName;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<Invoice> invoices;

	public Customer() {
		super();
	}

	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
	}

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Collection<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + "]";
	}

}