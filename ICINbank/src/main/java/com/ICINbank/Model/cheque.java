package com.ICINbank.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cheque")
public class cheque {
	@Id
	private String accid;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="status")
	private String status;

	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public cheque(String accid, String user_name, String status) {
		super();
		this.accid = accid;
		this.user_name = user_name;
		this.status = status;
	}

	public cheque() {
		super();
	}

	@Override
	public String toString() {
		return "cheque [accid=" + accid + ", user_name=" + user_name + ", status=" + status + "]";
	}
	
	
}
