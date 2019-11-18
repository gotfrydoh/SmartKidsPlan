package com.hgprojects.smartkidsplan.service;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Schedule;

public interface ScheduleService {

	public List<Schedule> getSchedules();

	public void saveSchedule(Schedule theSchedule);

	public void deleteSchedule(int theId);

	public Schedule getSchedule(int theId);

	public List<Schedule> searchSchedule(String theSearchName);
	
}
