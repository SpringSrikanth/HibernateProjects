package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity //metion for it is entity class
//@Entity(name="Carectors") // it's used to change entity name
@Entity
@Table(name="Carectors")
public class Carector {
	@Id
	@Column(name="cId")
	private int charectorId;
	@Column(name="cName")
	private String charectorName;
	@Column(name="cType")
	private String charectorType;
	@Column(name="cGender")
	private String gender;
	@Column(name="cMovieName")
	private String movieName;
	
	private DirectorDetails DirectorDetails;
	
	public Carector() {}	

	public Carector(int charectorId, String charectorName, String charectorType, String gender, String movieName,
			com.hibernate.entity.DirectorDetails directorDetails) {
		super();
		this.charectorId = charectorId;
		this.charectorName = charectorName;
		this.charectorType = charectorType;
		this.gender = gender;
		this.movieName = movieName;
		DirectorDetails = directorDetails;
	}

	public int getCharectorId() {
		return charectorId;
	}
	public void setCharectorId(int charectorId) {
		this.charectorId = charectorId;
	}
	public String getCharectorName() {
		return charectorName;
	}
	public void setCharectorName(String charectorName) {
		this.charectorName = charectorName;
	}
	public String getCharectorType() {
		return charectorType;
	}
	public void setCharectorType(String charectorType) {
		this.charectorType = charectorType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	

	public DirectorDetails getDirectorDetails() {
		return DirectorDetails;
	}

	public void setDirectorDetails(DirectorDetails directorDetails) {
		DirectorDetails = directorDetails;
	}

	@Override
	public String toString() {
		return "Carector [charectorId=" + charectorId + ", charectorName=" + charectorName + ", charectorType="
				+ charectorType + ", gender=" + gender + ", movieName=" + movieName + ", DirectorDetails="
				+ DirectorDetails + "]";
	}		
}
