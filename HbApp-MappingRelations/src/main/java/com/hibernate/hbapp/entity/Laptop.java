package com.hibernate.hbapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Laptops")
public class Laptop {
	@Id
	@Column(name="lid")
	private int lid;
	private String companyName;
	private double price;
	
	public Laptop() {}
	public Laptop(int lid, String companyName, double price) {
		this.lid = lid;
		this.companyName = companyName;
		this.price = price;
	}

	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", companyName=" + companyName + ", price=" + price + "]";
	}

}
