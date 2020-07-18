package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Table")
public class Employee {
	@Id
	private int eid;
	private String ename;
	private double esal;
	
	@ManyToMany
	private List<PcSystem> pcSystems=new ArrayList<PcSystem>();
	public Employee() {}
	public Employee(int eid, String ename, double esal, List<PcSystem> pcSystems) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.pcSystems = pcSystems;
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
	public double getEsal() {
		return esal;
	}
	public void setEsal(double esal) {
		this.esal = esal;
	}
	public List<PcSystem> getPcSystems() {
		return pcSystems;
	}
	public void setPcSystems(List<PcSystem> pcSystems) {
		this.pcSystems = pcSystems;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", pcSystems=" + pcSystems + "]";
	}
	
}
