package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgprojects.smartkidsplan.entity.Caretaker;
import com.hgprojects.smartkidsplan.entity.Child;

@Repository
public class CaretakerDAOImpl implements CaretakerDAO {

	//need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Caretaker> getCaretakers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		//creating a query
		Query<Caretaker> theQuery = currentSession.createQuery("from Caretaker order by lastName",Caretaker.class);
		
		//execute the query
		List<Caretaker> caretakers = theQuery.getResultList();
		
		return caretakers;
	}


	@Override
	public void saveCaretaker(Caretaker theCaretaker) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCaretaker);
		
	}


	@Override
	public Caretaker getCaretaker(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Caretaker theCaretaker = currentSession.get(Caretaker.class, theId);
		return theCaretaker;
	}


	@Override
	public void deleteCaretaker(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Caretaker where id=:caretakerId");
		theQuery.setParameter("caretakerId", theId);
		theQuery.executeUpdate();
	}


	@Override
	public List<Caretaker> searchCaretaker(String theSearchName) {
Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Caretaker where lower(firstName) like :theName or lower(lastName) like :theName",Caretaker.class);
			theQuery.setParameter("theName","%"+theSearchName.toLowerCase()+"%");
		}
		else {
			//the search name is empty so just get all caretakers 
			theQuery=currentSession.createQuery("from Caretaker",Caretaker.class);
		}
		
		//execute the query
		List<Caretaker> caretakers = theQuery.getResultList();
		
		return caretakers;
	}

}
