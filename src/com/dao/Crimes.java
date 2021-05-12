package com.dao;
import java.io.Serializable;

public class Crimes implements java.io.Serializable {
	private int year;
	private String region;
	private int murder;
	private int sex_violence;
	private int assault;
	private int intrud;
	
	//기본 생성자
	public Crimes() {
		
	}
	
	public Crimes(int year, String region, int murder, int sex_violence, int assault, int intrud) {
		this.year=year;
		this.region=region;
		this.murder=murder;
		this.sex_violence=sex_violence;
		this.assault=assault;
		this.intrud=intrud;
	}
	
	
	//getter, setter
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getMurder() {
		return murder;
	}

	public void setMurder(int murder) {
		this.murder = murder;
	}

	public int getSex_violence() {
		return sex_violence;
	}

	public void setSex_violence(int sex_violence) {
		this.sex_violence = sex_violence;
	}

	public int getAssault() {
		return assault;
	}

	public void setAssault(int assault) {
		this.assault = assault;
	}

	public int getIntrud() {
		return intrud;
	}

	public void setIntrud(int intrud) {
		this.intrud = intrud;
	}
	
}
