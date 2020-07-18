package com.hibernate.hbapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name="Employees")
public class Employee {
	@Id
	private int eid;
	private String ename;
	private String companyName;
	// one to one relationship here the laptop id will stored in student table
	@OneToOne  
	private Laptop laptop;
	
	public Employee() {	}

	
	public Employee(int eid, String ename, String companyName, Laptop laptop) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.companyName = companyName;
		this.laptop = laptop;
	}


	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", companyName=" + companyName + ", laptop=" + laptop
				+ "]";
	}

    
}
