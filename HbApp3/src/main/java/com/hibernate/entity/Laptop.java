package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laptop_table" ,schema ="mydb")
public class Laptop 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	private String brand;
	private double price;
    public Laptop() {}
	public Laptop(int lid, String brand, double price) {
		this.lid = lid;
		this.brand = brand;
		this.price = price;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + ", price=" + price + "]";
	}
}
