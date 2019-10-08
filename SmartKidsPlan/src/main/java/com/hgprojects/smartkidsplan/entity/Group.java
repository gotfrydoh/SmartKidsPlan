package com.hgprojects.smartkidsplan.entity;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="session")
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="day_of_week")
	private int dayOfWeek;
	
	@Column(name="start_time")
	private LocalTime startTime;

	@Column(name="end_time")
	private LocalTime endTime;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	
	
	
	public Group(){
	
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDayOfWeek() {
		return dayOfWeek;
	}



	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	@Override
	public String toString() {
		return "Session [id=" + id + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", teacher=" + teacher + "]";
	}
	
	
	
	
}
