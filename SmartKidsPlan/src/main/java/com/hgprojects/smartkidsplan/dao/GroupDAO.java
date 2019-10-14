package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Group;

public interface GroupDAO {

	public List<Group> getGroups();

	public void saveGroup(Group theGroup);

	public Group getGroup(int groupId);

	public void deleteGroup(int groupId);

	public List<Group> searchGroup(String theSearchName);
}
