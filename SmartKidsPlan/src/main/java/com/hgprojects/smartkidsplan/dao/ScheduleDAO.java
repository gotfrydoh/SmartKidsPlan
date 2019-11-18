package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Schedule;

public interface ScheduleDAO {

	public List<Schedule> getSchedules();

	public void saveSchedule(Schedule theSchedule);

	public void deleteSchedule(int theId);

	public Schedule getSchedule(int theId);

	public List<Schedule> searchSchedule(String theSearchName);

	public List<Schedule> getDailySchedules(int dayOfWeek);
	
}
