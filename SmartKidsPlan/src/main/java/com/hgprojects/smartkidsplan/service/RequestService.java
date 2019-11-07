package com.hgprojects.smartkidsplan.service;

import java.util.Date;
import java.util.List;

import com.hgprojects.smartkidsplan.entity.Request;

public interface RequestService {

	public List<Request> getRequests();

	public void saveRequest(Request theRequest);

	public void deleteRequest(int theId);

	public Request getRequest(int theId);

	public List<Request> searchRequest(String theSearchName);
	
	public List<Request> getRequestsAfterDate(Date theDate);
}
