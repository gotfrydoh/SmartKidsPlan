package com.hgprojects.smartkidsplan.service;

import java.util.List;

import com.hgprojects.smartkidsplan.entity.Caretaker;

public interface CaretakerService {

	public List<Caretaker> getCaretakers();

	public void saveCaretaker(Caretaker theCaretaker);

	public Caretaker getCaretakeer(int theId);

	public void deleteCaretaker(int theId);

	public List<Caretaker> searchCaretaker(String theSearchName);
}
