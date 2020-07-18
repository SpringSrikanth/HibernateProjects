package com.hibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Addresses")
public class Address {
	@Id
	private int aid;
	private String hno;
	private String streetName;
	private String city;
	private String state;
	private int pincode;
	
	@ManyToOne
	private Person person;
	public Address() {}
	public Address(int aid,String hno, String streetName, String city, String state, int pincode, Person person) {
		super();
		this.aid=aid;
		this.hno = hno;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.person = person;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", hno=" + hno + ", streetName=" + streetName + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", person=" + person + "]";
	}

	
	
}
