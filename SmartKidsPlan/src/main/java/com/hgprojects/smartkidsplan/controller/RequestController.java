package com.hgprojects.smartkidsplan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hgprojects.smartkidsplan.entity.Caretaker;
import com.hgprojects.smartkidsplan.entity.Request;
import com.hgprojects.smartkidsplan.service.CaretakerService;
import com.hgprojects.smartkidsplan.service.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {

	@Autowired 
	private RequestService requestService;
	
	@Autowired
	private CaretakerService caretakerService;
	
	@GetMapping("/list")
	public String listRequests(Model theModel) {
		List<Request> requests = requestService.getRequests();
		theModel.addAttribute("requests",requests);
		return "list-requests";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Request theRequest = new Request();
		List<Caretaker> caretakers = caretakerService.getCaretakers();
		theModel.addAttribute("caretakers", caretakers);
		theModel.addAttribute("request",theRequest);
		return "request-form";
	}
	
	
	@PostMapping("/saveRequest")
	public String saveRequest(@ModelAttribute("request") Request theRequest) {
		requestService.saveRequest(theRequest);
		return "redirect:/request/list";
	}
	
	
	@GetMapping("/delete")
	public String deleteRequest(@RequestParam("requestId") int theId, Model theModel) {
		requestService.deleteRequest(theId);
		return "redirect:/request/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("requestId") int theId, Model theModel) {
		Request theRequest = requestService.getRequest(theId);
		List<Caretaker> caretakers = caretakerService.getCaretakers();
		theModel.addAttribute("caretakers", caretakers);
		theModel.addAttribute("request",theRequest);
		return "request-form";
	}
	
	@GetMapping("/search")
	public String searchRequest(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		List<Request> theRequests = requestService.searchRequest(theSearchName);
		theModel.addAttribute("requests", theRequests);
		return "list-requests";
	}
	
	
}
