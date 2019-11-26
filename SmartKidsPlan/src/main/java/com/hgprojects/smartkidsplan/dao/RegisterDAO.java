package com.hgprojects.smartkidsplan.dao;

import java.util.Date;
import java.util.List;

import com.hgprojects.smartkidsplan.entity.Register;

public interface RegisterDAO {

	public List<Register> getRegisters();

	public void saveRegister(Register theRegister);

	public void deleteRegister(int theId);

	public Register getRegister(int theId);

	public List<Register> searchRegister(String theSearchName);

	public List<Register> getNullTeacherRegisters();

	public List<Register> getRegistersafterDate(Date dateOfAttendance);

	public Register getIfExistsDate(Register tempRegister);
}
