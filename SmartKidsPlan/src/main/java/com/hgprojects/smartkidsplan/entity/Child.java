package com.hgprojects.smartkidsplan.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="child")
public class Child {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="pesel")
	private int pesel;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	
	public Child() {
		
	}
	
	
	public Child(String firstName, String lastName, int pesel, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.dateOfBirth = dateOfBirth;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getPesel() {
		return pesel;
	}


	public void setPesel(int pesel) {
		this.pesel = pesel;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	@Override
	public String toString() {
		return "Child [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pesel=" + pesel
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
	
	
	
}
