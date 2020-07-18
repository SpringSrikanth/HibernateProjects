package com.hibernate.HbApp2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Students")
public class Student {
	@Id
	@Column(name="sid")
	private int sid;
	private String fname;
	private String sname;
	@Transient
	private String email;
	private int persentage;
	public Student() {}
	
	public Student(int sid, String fname, String sname, String email, int persentage) {
		super();
		this.sid = sid;
		this.fname = fname;
		this.sname = sname;
		this.email = email;
		this.persentage = persentage;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPersentage() {
		return persentage;
	}

	public void setPersentage(int persentage) {
		this.persentage = persentage;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", fname=" + fname + ", sname=" + sname + ", email=" + email + ", persentage="
				+ persentage + "]";
	}
	
}
