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
import com.hgprojects.smartkidsplan.entity.Child;
import com.hgprojects.smartkidsplan.service.CaretakerService;

@Controller
@RequestMapping("/caretaker")
public class CaretakerController {
	
	//need to inject caretaker service
	@Autowired
	private CaretakerService caretakerService;
	
	
	@GetMapping("/list")
	public String listCaretakers(Model theModel) {
		//getting caretakers from the service
		List<Caretaker> theCaretakers = caretakerService.getCaretakers();
		theModel.addAttribute("caretakers",theCaretakers);
		return "list-caretakers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Caretaker theCaretaker = new Caretaker();
		theModel.addAttribute("caretaker", theCaretaker);
		return "caretaker-form";
	}
	
	@PostMapping("/saveCaretaker")
	public String saveCaretaker(@ModelAttribute("caretaker") Caretaker theCaretaker) {
		//saving caretaker using service
		caretakerService.saveCaretaker(theCaretaker);
		return "redirect:/caretaker/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("caretakerId") int theId, Model theModel) {
		Caretaker theCaretaker = caretakerService.getCaretakeer(theId);
		theModel.addAttribute("caretaker",theCaretaker);
		return "caretaker-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteCaretaker(@RequestParam("caretakerId") int theId, Model theModel) {
		caretakerService.deleteCaretaker(theId);
		return "redirect:/caretaker/list";
	}
	
	
	@GetMapping("/search")
	public String searchCaretaker(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		List<Caretaker> theCaretakers = caretakerService.searchCaretaker(theSearchName);
		theModel.addAttribute("caretakers", theCaretakers);
		return "list-caretakers";
	}
	
	@GetMapping("/showFormForAddChild")
	public String showFormForAddChild(@RequestParam("caretakerId") int theId, Model theModel) {
		//getting children of caretaker with this id
		List<Child> children = caretakerService.getChildren(theId);
		theModel.addAttribute("caretakerChildren", children);
		return "caretaker-children";
	}
	
	
	
}
