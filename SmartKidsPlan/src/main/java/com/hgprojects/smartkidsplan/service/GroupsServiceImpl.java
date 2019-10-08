package com.hgprojects.smartkidsplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgprojects.smartkidsplan.entity.Group;
import com.hgprojects.smartkidsplan.dao.GroupDAO;

@Service
public class GroupsServiceImpl implements GroupService {

	@Autowired
	private GroupDAO groupDAO;
	
	
	@Override
	@Transactional
	public List<Group> getGroups() {
		return groupDAO.getGroups();
	}


	@Override
	@Transactional
	public void saveGroup(Group theGroup) {
		groupDAO.saveGroup(theGroup);
	}

}
