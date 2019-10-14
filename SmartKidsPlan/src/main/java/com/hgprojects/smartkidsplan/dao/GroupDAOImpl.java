package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgprojects.smartkidsplan.entity.Group;

@Repository
public class GroupDAOImpl implements GroupDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Group> getGroups() {	
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Group> theQuery = currentSession.createQuery("from Group order by teacher",Group.class);
		List<Group> groups = theQuery.getResultList();
		return groups;
	}


	@Override
	public void saveGroup(Group theGroup) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theGroup);
	}


	@Override
	public Group getGroup(int groupId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Group theGroup = currentSession.get(Group.class, groupId);
		return theGroup;
	}


	@Override
	public void deleteGroup(int groupId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Group where id=:groupId");
		theQuery.setParameter("groupId", groupId);
		theQuery.executeUpdate();		
	}


	@Override
	public List<Group> searchGroup(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Group where lower(teacher.firstName) like :theName or lower(teacher.lastName) like :theName",Group.class);
			theQuery.setParameter("theName", "%"+theSearchName.toLowerCase()+"%");
		}
		else {
			//theSearchName is empty so get all groups
			theQuery=currentSession.createQuery("from Group", Group.class);
		}
		//execute the query
		List<Group> groups = theQuery.getResultList();
		return groups;
	}

	
	
	
}
