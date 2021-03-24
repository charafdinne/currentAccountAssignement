package com.assignement.entities;

public class AccountCreationBody {

	Integer CustomerId;
	Integer balance;

	public AccountCreationBody() {
	}

	public AccountCreationBody(Integer customrId, Integer balance) {
		CustomerId = customrId;
		this.balance = balance;
	}

	public Integer getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Integer customrId) {
		CustomerId = customrId;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
