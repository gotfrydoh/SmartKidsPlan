package com.hgprojects.smartkidsplan.service;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Group;

public interface GroupService {

	public List<Group> getGroups();

	public void saveGroup(Group theGroup);

	public void deleteGroup(int groupId);

	public Group getGroup(int groupId);

	public List<Group> searchGroup(String theSearchName);
}
