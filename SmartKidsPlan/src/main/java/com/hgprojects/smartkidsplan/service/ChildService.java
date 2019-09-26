package com.hgprojects.smartkidsplan.service;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Child;

public interface ChildService {

	
	public List<Child> getChildren();

	public void saveChild(Child theChild);

	public Child getChild(int theId);

	public void deleteChild(int theId);

	public List<Child> searchChild(String theSearchName);
}
