package com.hibernate.hb.hql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String sname;
	private String per;
	public Student() {}
	public Student(int sid, String sname, String per) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.per = per;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", per=" + per + "]";
	}
	
	
}
