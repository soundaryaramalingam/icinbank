package com.ICINbank.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	private String emailid;
	
	@Column(name="accid")
	private String accid;
	
	@Column(name="user_name")
	private String user_name;
	
	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}

	@Column(name="dob")
	private String dob;
	
	@Column(name="phnumber")
	private long phnumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pass")
	private String pass;

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(long phnumber) {
		this.phnumber = phnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User(String emailid,String accid, String user_name, String dob, long phnumber, String address, String pass) {
		super();
		this.emailid = emailid;
		this.user_name = user_name;
		this.dob = dob;
		this.phnumber = phnumber;
		this.address = address;
		this.pass = pass;
		this.accid=accid;
	}

	public User() {
		super();
	}
	
	
}