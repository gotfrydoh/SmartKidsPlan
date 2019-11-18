package com.hgprojects.smartkidsplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgprojects.smartkidsplan.dao.ScheduleDAO;
import com.hgprojects.smartkidsplan.entity.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDAO scheduleDAO;
	
	@Override
	@Transactional
	public List<Schedule> getSchedules() {
		return scheduleDAO.getSchedules();
	}

	@Override
	@Transactional
	public void saveSchedule(Schedule theSchedule) {
		scheduleDAO.saveSchedule(theSchedule);
		
	}

	@Override
	@Transactional
	public void deleteSchedule(int theId) {
		scheduleDAO.deleteSchedule(theId);
	}

	@Override
	@Transactional
	public Schedule getSchedule(int theId) {
		return scheduleDAO.getSchedule(theId);
	}

	@Override
	@Transactional
	public List<Schedule> searchSchedule(String theSearchName) {
		return scheduleDAO.searchSchedule(theSearchName);
	}

}
