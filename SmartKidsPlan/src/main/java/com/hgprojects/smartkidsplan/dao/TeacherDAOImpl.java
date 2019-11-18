package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgprojects.smartkidsplan.entity.Register;
import com.hgprojects.smartkidsplan.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Teacher> getTeachers() {
		//getting current session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//creating a query
		Query<Teacher> theQuery = currentSession.createQuery("from Teacher order by lastName", Teacher.class);
		
		//execute the query
		List<Teacher> teachers = theQuery.getResultList();
		
		return teachers;
	}


	@Override
	public void saveTeacher(Teacher theTeacher) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTeacher);
	}


	@Override
	public Teacher getTeacher(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Teacher theTeacher = currentSession.get(Teacher.class, theId);
		return theTeacher;
	}


	@Override
	public void deleteTeacher(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Teacher where id=:teacherId");
		theQuery.setParameter("teacherId", theId);
		theQuery.executeUpdate();
		
	}


	@Override
	public List<Teacher> searchTeacher(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Teacher where lower(firstName) like :theName or lower(lastName) like :theName",Teacher.class);
			theQuery.setParameter("theName","%"+theSearchName.toLowerCase()+"%");
		}
		else {
			//the search name is empty so just get all teachers 
			theQuery=currentSession.createQuery("from Teacher",Teacher.class);
		}
		
		//execute the query
		List<Teacher> teachers = theQuery.getResultList();
		
		return teachers;
	}


	
	
	
	
	

}
