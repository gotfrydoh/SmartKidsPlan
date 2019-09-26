package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.*;

public interface ChildDAO {

	public List<Child> getChildren();

	public void saveChild(Child theChild);

	public Child getChild(int theId);

	public void deleteChild(int theId);

	public List<Child> searchChild(String theSearchName);
}
