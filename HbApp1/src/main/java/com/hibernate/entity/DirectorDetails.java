package com.hibernate.entity;

import javax.persistence.Embeddable;
@Embeddable
public class DirectorDetails {
	
	private String directorName;
	private String screenPlay;
	private String country;
	
	public DirectorDetails() {
		super();
	}
	public DirectorDetails(String directorName, String screenPlay, String country) {
		this.directorName = directorName;
		this.screenPlay = screenPlay;
		this.country = country;
	}

	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getScreenPlay() {
		return screenPlay;
	}
	public void setScreenPlay(String screenPlay) {
		this.screenPlay = screenPlay;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "DirectorDetails [directorName=" + directorName + ", screenPlay=" + screenPlay + ", country=" + country
				+ "]";
	}
	
}
