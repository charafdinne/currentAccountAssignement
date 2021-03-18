package com.assignement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	@Column
	Integer accountId;

	@Column
	String title;

	@Column
	String description;

	@Column
	Date creation_date;

	@Column
	Boolean is_closed;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	Customer customer;

	public Account() {
	}

	public Account(Integer accountId, String title, String description, Date creation_date, Boolean is_closed) {
		super();
		this.accountId = accountId;
		this.title = title;
		this.description = description;
		this.creation_date = creation_date;
		this.is_closed = is_closed;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Boolean getIs_closed() {
		return is_closed;
	}

	public void setIs_closed(Boolean is_closed) {
		this.is_closed = is_closed;
	}

}
