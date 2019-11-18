package com.hgprojects.smartkidsplan.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgprojects.smartkidsplan.dao.ScheduleDAO;
import com.hgprojects.smartkidsplan.dao.TeacherDAO;
import com.hgprojects.smartkidsplan.entity.Schedule;
import com.hgprojects.smartkidsplan.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	
	//need to inject teacher DAO
	@Autowired
	private TeacherDAO teacherDAO;
	
	@Autowired
	private ScheduleDAO scheduleDAO;

	
	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		return teacherDAO.getTeachers();
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher theTeacher) {
		teacherDAO.saveTeacher(theTeacher);
	}

	@Override
	@Transactional
	public Teacher getTeacher(int theId) {
		return teacherDAO.getTeacher(theId);
	}

	@Override
	@Transactional
	public void deleteTeacher(int theId) {
		teacherDAO.deleteTeacher(theId);
	}

	@Override
	@Transactional
	public List<Teacher> searchTeacher(String theSearchName) {
		return teacherDAO.searchTeacher(theSearchName);
	}

	@Override
	@Transactional
	public List<Teacher> getDaily2ndShiftTeachers(int dayOfWeek) {
		List<Schedule> dailySchedules = scheduleDAO.getDailySchedules(dayOfWeek);
		List<Teacher> teachers = new ArrayList<>();
		for(int i=0; i<dailySchedules.size(); i++) {
			teachers.add(dailySchedules.get(i).getTeacher());
		}
		return teachers;
	}

	
	
}
