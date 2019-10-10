package com.hgprojects.smartkidsplan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {

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

	@OneToMany(mappedBy="teacher",fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Group> groups;

	public Teacher() {
		
	}
	

	public void addGroup(Group tempSession) {
		if(groups == null) {
			groups = new ArrayList<>();
		}
		groups.add(tempSession);
		tempSession.setTeacher(this);
	}
	
	
	public void removeGroup(Group tempGroup) {
		if(groups != null) {
			for(int i=0;i<groups.size();i++) {
				if(tempGroup.getId() == groups.get(i).getId()) {
					tempGroup.setTeacher(null);
					groups.remove(i);
					i--;
				}
			}
		}
	}

	public Teacher(String firstName, String lastName, int pesel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}



	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
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


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pesel=" + pesel + "]";
	}

	
	

}



