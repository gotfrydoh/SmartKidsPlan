package com.hgprojects.smartkidsplan.service;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Teacher;

public interface TeacherService {

	
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacher(int theId);

	public void deleteTeacher(int theId);

	public List<Teacher> searchTeacher(String theSearchName);
}
