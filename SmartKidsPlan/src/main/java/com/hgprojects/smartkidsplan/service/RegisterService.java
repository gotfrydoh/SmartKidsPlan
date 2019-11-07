package com.hgprojects.smartkidsplan.service;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Register;
import com.hgprojects.smartkidsplan.entity.Teacher;

public interface RegisterService {

	public List<Register> getRegisters();

	public void saveRegister(Register theRegister);

	public void deleteRegister(int theId);

	public Register getRegister(int theId);

	public List<Register> searchRegister(String theSearchName);

	public List<Register> getNullTeacherRegisters();

	public void setTeacherToRegister(Register register, Teacher minHoursTeacher);
	
}
