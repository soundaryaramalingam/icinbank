package com.ICINbank.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	private String accid;
	
	@Column(name="active")
	private String active;
	
	@Column(name="balance")
	private long balance;

	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public Account(String accid, String active, long balance) {
		super();
		this.accid = accid;
		this.active = active;
		this.balance = balance;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accid=" + accid + ", active=" + active + ", balance=" + balance + "]";
	}
	
	
	
}
