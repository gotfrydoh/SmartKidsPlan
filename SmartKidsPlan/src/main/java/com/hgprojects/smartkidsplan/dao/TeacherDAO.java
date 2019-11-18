package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Teacher;

public interface TeacherDAO {

	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacher(int theId);

	public void deleteTeacher(int theId);

	public List<Teacher> searchTeacher(String theSearchName);

	
	
}
