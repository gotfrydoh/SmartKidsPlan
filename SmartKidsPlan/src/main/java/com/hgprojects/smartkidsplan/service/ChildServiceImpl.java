package com.hgprojects.smartkidsplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgprojects.smartkidsplan.dao.ChildDAO;
import com.hgprojects.smartkidsplan.entity.Caretaker;
import com.hgprojects.smartkidsplan.entity.Child;

@Service
public class ChildServiceImpl implements ChildService {

	//need to inject child DAO
	@Autowired
	private ChildDAO childDAO;
	
	@Override
	@Transactional
	public List<Child> getChildren() {
		return childDAO.getChildren();
	}

	@Override
	@Transactional
	public void saveChild(Child theChild) {
		 childDAO.saveChild(theChild);
		
	}

	@Override
	@Transactional
	public Child getChild(int theId) {
		return childDAO.getChild(theId);
	}

	@Override
	@Transactional
	public void deleteChild(int theId) {
		childDAO.deleteChild(theId);
		
	}

	@Override
	@Transactional
	public List<Child> searchChild(String theSearchName) {
		return childDAO.searchChild(theSearchName);
	}

	@Override
	@Transactional
	public List<Caretaker> getChildCaretakers(int theId) {
		Child theChild = childDAO.getChild(theId);
		return theChild.getCaretakers();
	}

}
