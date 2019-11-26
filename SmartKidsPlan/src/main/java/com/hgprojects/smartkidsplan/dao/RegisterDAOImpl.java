package com.hgprojects.smartkidsplan.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgprojects.smartkidsplan.entity.Register;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Register> getRegisters() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Register order by dateOfAttendance");
		List<Register> registers = theQuery.getResultList();		
		return registers;
	}

	@Override
	public void saveRegister(Register theRegister) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theRegister);
		
	}

	@Override
	public void deleteRegister(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Register where id=:registerId");
		theQuery.setParameter("registerId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public Register getRegister(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Register theRegister = currentSession.get(Register.class, theId);
		return theRegister;
	}

	@Override
	public List<Register> searchRegister(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0 ) {
			theQuery = currentSession.createQuery("from Register where lower(name) like :theName "
					+ "or lower(description) like :theName "
					+ "or startTime like :theName "
					+ "or endTime like :theName "
					+ "or dateOfAttendance like :theName "
					+ "or teacher.firstName like :theName "
					+ "or teacher.lastName like :theName "
				, Register.class);
			theQuery.setParameter("theName", "%"+theSearchName.toLowerCase()+"%");
			}
		else {
			//search name is empty so just get all registers
			theQuery = currentSession.createQuery("from Register",Register.class);
		}
		
		//execute the query
		List<Register> registers = theQuery.getResultList();
		
		return registers;
	}

	@Override
	public List<Register> getNullTeacherRegisters() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Register where teacher is null");
		List<Register> registers = theQuery.getResultList();
		return registers;
	}

	@Override
	public List<Register> getRegistersafterDate(Date dateOfAttendance) {
		Session currentSession = sessionFactory.getCurrentSession();
		String overHours = "nadgodziny";
		Query theQuery = currentSession.createQuery("from Register where dateOfAttendance>=:theDate and name=:theName");
		theQuery.setParameter("theDate", dateOfAttendance);
		theQuery.setParameter("theName",overHours);
		List<Register> registers = theQuery.getResultList();
		return registers;
	}

	@Override
	public Register getIfExistsDate(Register tempRegister) {
		Session currentSession = sessionFactory.getCurrentSession();
		String overHours = "nadgodziny";
		Query theQuery = currentSession.createQuery("from Register where dateOfAttendance=:theDate and name=:theName");
		theQuery.setParameter("theDate", tempRegister.getDateOfAttendance());
		theQuery.setParameter("theName",overHours);
		List<Register> registers = theQuery.getResultList();
		if(registers.size() > 0 ) {
			return registers.get(0);
		}
		else {
			return null;
		}
		
	}

}
