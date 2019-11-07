package com.hgprojects.smartkidsplan.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgprojects.smartkidsplan.dao.RequestDAO;
import com.hgprojects.smartkidsplan.entity.Request;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestDAO requestDAO;
	
	
	@Override
	@Transactional
	public List<Request> getRequests() {
		return requestDAO.getRequests();
	}


	@Override
	@Transactional
	public void saveRequest(Request theRequest) {
		requestDAO.saveRequest(theRequest);
	}


	@Override
	@Transactional
	public void deleteRequest(int theId) {
		requestDAO.deleteRequest(theId);
	}


	@Override
	@Transactional
	public Request getRequest(int theId) {
		return requestDAO.getRequest(theId);
	}


	@Override
	@Transactional
	public List<Request> searchRequest(String theSearchName) {
		return requestDAO.searchRequest(theSearchName);
	}


	@Override
	@Transactional
	public List<Request> getRequestsAfterDate(Date theDate) {
		return requestDAO.getRequestsAfterDate(theDate);
	}

}
