package com.example.demo.model;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	
	
//	@OneToMany(targetEntity=Customer.class)  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int accountNumber = (100000 + new Random().nextInt(900000));
	private int accountNumber;

	private String accountType;
	private int accountStatus = 1;
	private double ammount = 0;
	
	//added json ignore due to json looping 
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_Id")

	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
//	@Override
//	public String toString() {
//		return "Account[accountNumber="+ accountNumber + ", AccountStatus = " + accountStatus + "]"; 
//	}
//	
//	

}
