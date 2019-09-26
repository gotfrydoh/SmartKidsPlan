package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgprojects.smartkidsplan.entity.Child;


@Repository
public class ChildDAOImpl implements ChildDAO {

	//need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Child> getChildren() {
	
		//getting current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//creating a query
		Query<Child> theQuery = currentSession.createQuery("from Child order by lastName", Child.class);
		
		//execute the query
		List<Child> children = theQuery.getResultList();
		
		
		return children;
	}

	@Override
	public void saveChild(Child theChild) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theChild);
	}

	
	@Override
	public Child getChild(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Child theChild = currentSession.get(Child.class, theId);
		return theChild;
	}

	@Override
	public void deleteChild(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Child where id=:childId");
		theQuery.setParameter("childId", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Child> searchChild(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Child where lower(firstName) like :theName or lower(lastName) like :theName",Child.class);
			theQuery.setParameter("theName","%"+theSearchName.toLowerCase()+"%");
		}
		else {
			//the search name is empty so just get all children 
			theQuery=currentSession.createQuery("from Child",Child.class);
		}
		
		//execute the query
		List<Child> children = theQuery.getResultList();
		
		return children;
	}

}
