package com.assignement.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer customerId;
	
	@Column
	String name;
	
	@Column 
	String surname;
	
	@Column
	String adresse;

	@OneToMany
	Set<Account> accounts;
	
	public Customer() {
	}
	
	public Customer(String name, String surname, String addresse) {
		this.name = name;
		this.surname = surname;
		this.adresse = addresse;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddresse() {
		return adresse;
	}

	public void setAddresse(String addresse) {
		this.adresse = addresse;
	}
}
