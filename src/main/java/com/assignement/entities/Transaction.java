package com.assignement.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Transaction {

	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer transactionId;
	
	@OneToMany
	Set<Account> accounts;
	
	@ManyToOne
	@JoinColumn(name= "account_id", nullable = false)
	Account account;
	
	public Transaction() {
	}

	public Transaction(Integer transactionId, Set<Account> accounts, Account account) {
		super();
		this.transactionId = transactionId;
		this.accounts = accounts;
		this.account = account;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
