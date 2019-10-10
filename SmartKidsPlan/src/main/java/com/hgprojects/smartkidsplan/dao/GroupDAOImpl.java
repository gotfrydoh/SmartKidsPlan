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

	
	
	
}
