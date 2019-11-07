package com.hgprojects.smartkidsplan.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="register")
public class Register {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_time")
	private LocalTime startTime;
	
	@Column(name="end_time")
	private LocalTime endTime;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="date")
	private Date dateOfAttendance; 
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="teacher_id")
	private Teacher teacher;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="register_id")
	private List<Request> requests;
	
	
	public void addRequest(Request tempRequest) {
		if(requests == null) {
			requests = new ArrayList<>();
		}
		requests.add(tempRequest);
	}
	
	
	public Register() {
		
	}
	
	
	
	public Register(String name, String description, LocalTime startTime, LocalTime endTime, Date dateOfAttendance) {
		super();
		this.name = name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dateOfAttendance = dateOfAttendance;
	}


	public List<Request> getRequests() {
		return requests;
	}


	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Date getDateOfAttendance() {
		return dateOfAttendance;
	}

	public void setDateOfAttendance(Date dateOfAttendance) {
		this.dateOfAttendance = dateOfAttendance;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	

	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", description=" + description + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", dateOfAttendance=" + dateOfAttendance + ", teacher=" + teacher + "]";
	}
	
	
	
	
}
