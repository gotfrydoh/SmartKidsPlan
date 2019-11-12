package com.hgprojects.smartkidsplan.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgprojects.smartkidsplan.entity.Register;
import com.hgprojects.smartkidsplan.entity.Request;

@Repository
public class RequestDAOImpl implements RequestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Request> getRequests() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Request order by dateOfAttendance");
		List<Request> requests = theQuery.getResultList();		
		return requests;
	}


	@Override
	public void saveRequest(Request theRequest) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theRequest);
	}

	@Override
	public void deleteRequest(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Request where id=:requestId");
		theQuery.setParameter("requestId", theId);
		theQuery.executeUpdate();
	}


	@Override
	public Request getRequest(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Request theRequest = currentSession.get(Request.class, theId);
		return theRequest;
	}


	@Override
	public List<Request> searchRequest(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0 ) {
			theQuery = currentSession.createQuery("from Request where "
					+ "startTime like :theName "
					+ "or endTime like :theName "
					+ "or dateOfAttendance like :theName "
					+ "or caretaker.firstName like :theName "
					+ "or caretaker.lastName like :theName "
				, Request.class);
			theQuery.setParameter("theName", "%"+theSearchName.toLowerCase()+"%");
			}
		else {
			//search name is empty so just get all registers
			theQuery = currentSession.createQuery("from Request",Request.class);
		}
		
		//execute the query
		List<Request> requests = theQuery.getResultList();
		
		return requests;
		
	}


	@Override
	public List<Request> getRequestsAfterDate(Date theDate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Request where dateOfAttendance>=:theDate and register is null order by dateOfAttendance");
		theQuery.setParameter("theDate", theDate);
		List<Request> requests = theQuery.getResultList();	
		return requests;
	}
	
	

}
