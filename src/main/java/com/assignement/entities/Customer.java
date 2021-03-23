package com.assignement.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer customerId;

	@Column
	String name;

	@Column
	String surname;

	@Column
	String adresse;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch = FetchType.EAGER)
	@JsonManagedReference
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

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		if (this.getAccounts() == null || this.getAccounts().isEmpty())
			this.accounts = new HashSet<Account>();
		this.accounts.add(account);
	}
}
