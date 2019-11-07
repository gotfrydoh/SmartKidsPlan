package com.hgprojects.smartkidsplan.dao;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Caretaker;


public interface CaretakerDAO {

	public List<Caretaker> getCaretakers();

	public void saveCaretaker(Caretaker theCaretaker);

	public Caretaker getCaretaker(int theId);

	public void deleteCaretaker(int theId);

	public List<Caretaker> searchCaretaker(String theSearchName);




}
