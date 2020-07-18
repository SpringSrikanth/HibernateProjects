package com.hibernate.hb.caching;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Alians")
@Cacheable(value=true)//to enable this entity for participating in second level cache
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) // which type of operations you need to perform on cache
public class Alian {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int alianId;
	private String alianName;
	private String alianColor;
	private String alianNicName;
	public Alian() {}	
	public Alian(int alianId, String alianName, String alianColor, String alianNicName) {
		this.alianId = alianId;
		this.alianName = alianName;
		this.alianColor = alianColor;
		this.alianNicName = alianNicName;
	}
	public int getAlianId() {
		return alianId;
	}
	public void setAlianId(int alianId) {
		this.alianId = alianId;
	}
	public String getAlianName() {
		return alianName;
	}
	public void setAlianName(String alianName) {
		this.alianName = alianName;
	}
	public String getAlianColor() {
		return alianColor;
	}
	public void setAlianColor(String alianColor) {
		this.alianColor = alianColor;
	}
	public String getAlianNicName() {
		return alianNicName;
	}
	public void setAlianNicName(String alianNicName) {
		this.alianNicName = alianNicName;
	}
	
	@Override
	public String toString() {
		return "Alian [alianId=" + alianId + ", alianName=" + alianName + ", alianColor=" + alianColor
				+ ", alianNicName=" + alianNicName + "]";
	}
	
	

}
