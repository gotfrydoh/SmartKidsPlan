package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Group;

public interface GroupDAO {

	public List<Group> getGroups();

	public void saveGroup(Group theGroup);
}
