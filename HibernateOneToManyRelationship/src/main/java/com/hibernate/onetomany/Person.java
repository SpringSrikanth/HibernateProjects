package com.hibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	
	@Id
	private int pid;
	private String fName;
	private String lName;
	private int pAge;
	private String pemail;
	@OneToMany(mappedBy="person")
	private List<Address> addresses= new ArrayList<Address>();
	public Person() {}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpAge(int pAge) {
		this.pAge = pAge;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", fName=" + fName + ", lName=" + lName + ", pAge=" + pAge + ", pemail=" + pemail
				+ ", addresses=" + addresses + "]";
	}
	public Person(int pid, String fName, String lName, int pAge, String pemail, List<Address> addresses) {
		super();
		this.pid = pid;
		this.fName = fName;
		this.lName = lName;
		this.pAge = pAge;
		this.pemail = pemail;
		this.addresses = addresses;
	}
	
	
}


