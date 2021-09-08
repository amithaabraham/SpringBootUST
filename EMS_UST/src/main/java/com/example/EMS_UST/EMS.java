package com.example.EMS_UST;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component //identify the bean class

@Entity  //This tells JPA that this class contains all details of tables

@Table(name="INDUST")

public class EMS 
{

	@Id
	@Column(name="id")
	private String eID;
	
	@Column(name="ename")
	private String eName;
	
	@Column(name="esal")
	private String eSal;
	
	
	public String geteID() 
	{
		return eID;
	}
	public void seteID(String eID) 
	{
		this.eID = eID;
	}
	public String geteName() 
	{
		return eName;
	}
	public void seteName(String eName) 
	{
		this.eName = eName;
	}
	public String geteSal() {
		return eSal;
	}
	public void seteSal(String eSal) 
	{
		this.eSal = eSal;
	}
	
	
}
