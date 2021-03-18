package com.assignement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@Column
	Integer transactionId;
}
