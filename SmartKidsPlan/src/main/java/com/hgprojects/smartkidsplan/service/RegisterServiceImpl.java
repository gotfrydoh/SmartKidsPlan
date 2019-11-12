package com.hgprojects.smartkidsplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgprojects.smartkidsplan.dao.RegisterDAO;
import com.hgprojects.smartkidsplan.entity.Register;
import com.hgprojects.smartkidsplan.entity.Request;
import com.hgprojects.smartkidsplan.entity.Teacher;


@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;
	
	
	@Override
	@Transactional
	public List<Register> getRegisters() {
		return registerDAO.getRegisters();
	}


	@Override
	@Transactional
	public void saveRegister(Register theRegister) {
		registerDAO.saveRegister(theRegister);
		
	}


	@Override
	@Transactional
	public void deleteRegister(int theId) {
		registerDAO.deleteRegister(theId);
	}


	@Override
	@Transactional
	public Register getRegister(int theId) {
		return registerDAO.getRegister(theId);
	}


	@Override
	@Transactional
	public List<Register> searchRegister(String theSearchName) {
		return registerDAO.searchRegister(theSearchName);
	}


	@Override
	@Transactional
	public List<Register> getNullTeacherRegisters() {
		return registerDAO.getNullTeacherRegisters();
	}


	@Override
	@Transactional
	public void setTeacherToRegister(Register register, Teacher minHoursTeacher) {
		register.setTeacher(minHoursTeacher);
		minHoursTeacher.addRegister(register);
	}


	@Override
	@Transactional
	public void addRequestToRegister(Register tempRegister, Request tempRequest) {
		tempRegister.addRequest(tempRequest);
		tempRequest.setRegister(tempRegister);
		
		
	}

}
