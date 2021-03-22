package com.assignement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Transaction {

	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer transactionId;

	@Column(name = "balance")
	Integer balance;

	/*
	 * true => add credit | false => subtract credit
	 */
	@Column(name = "transaction_type")
	Boolean transaction_type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	@JsonBackReference
	Account account;

	public Transaction() {
	}

	public Transaction(Integer balance, Boolean transaction_type) {
		super();
		this.balance = balance;
		this.transaction_type = transaction_type;
		this.account = account;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Boolean getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(Boolean transaction_type) {
		this.transaction_type = transaction_type;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
