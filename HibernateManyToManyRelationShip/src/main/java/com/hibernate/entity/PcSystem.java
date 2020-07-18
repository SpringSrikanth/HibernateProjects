package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PCs")
public class PcSystem {
	@Id
	private int pcId;
	private String osName;
	private double price;
	private String ram;
	private String rom;
	
	@ManyToMany(mappedBy="pcSystems")
	private List<Employee> employees = new ArrayList<Employee>();
	public PcSystem() {	}
	public PcSystem(int pcId, String osName, double price, String ram, String rom, List<Employee> employees) {
		super();
		this.pcId = pcId;
		this.osName = osName;
		this.price = price;
		this.ram = ram;
		this.rom = rom;
		this.employees = employees;
	}
	public int getPcId() {
		return pcId;
	}
	public void setPcId(int pcId) {
		this.pcId = pcId;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "PcSystem [pcId=" + pcId + ", osName=" + osName + ", price=" + price + ", ram=" + ram + ", rom=" + rom
				+ ", employees=" + employees + "]";
	}
	
}