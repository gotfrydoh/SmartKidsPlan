package com.hgprojects.smartkidsplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgprojects.smartkidsplan.dao.CaretakerDAO;
import com.hgprojects.smartkidsplan.entity.Caretaker;


@Service
public class CaretakerServiceImpl implements CaretakerService {

	//need to inject caretaker DAO
	@Autowired
	private CaretakerDAO caretakerDAO;
		
	
	@Override
	@Transactional
	public List<Caretaker> getCaretakers() {
		return caretakerDAO.getCaretakers();
	}

	@Override
	@Transactional
	public void saveCaretaker(Caretaker theCaretaker) {
		caretakerDAO.saveCaretaker(theCaretaker);
		
	}

	@Override
	@Transactional
	public Caretaker getCaretakeer(int theId) {
		return caretakerDAO.getCaretaker(theId);
	}

	@Override
	@Transactional
	public void deleteCaretaker(int theId) {
		caretakerDAO.deleteCaretaker(theId);
	}

	@Override
	@Transactional
	public List<Caretaker> searchCaretaker(String theSearchName) {
		return caretakerDAO.searchCaretaker(theSearchName);
	}




	

	
	
}
