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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="caretaker")
public class Caretaker {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="pesel")
	private long pesel;
	
	@Column(name="phone_number")
	private long phoneNumber;

	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(
			name="caretaker_child",
			joinColumns=@JoinColumn(name="caretaker_id"),
			inverseJoinColumns=@JoinColumn(name="child_id")
			)
	private List<Child> children;
	
	
	public Caretaker() {
		
	}
	
	
	//add a convenience method to addinf children to parent
	public void addChild(Child theChild) {
		
		if(children==null) {
			children = new ArrayList<>();
		}
		children.add(theChild);
	}
	
	public void removeChild(Child theChild) {
		
		if(children!=null) {
			for(int i=0; i<children.size(); i++) {
				if(theChild.getId()==children.get(i).getId()) {
					children.remove(i);
					i--;
				}
			}
		}
	}
	
	
	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
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

	public long getPesel() {
		return pesel;
	}

	public void setPesel(long pesel) {
		this.pesel = pesel;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "Caretaker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pesel=" + pesel
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
