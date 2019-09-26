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

import com.hgprojects.smartkidsplan.entity.Child;
import com.hgprojects.smartkidsplan.service.ChildService;

@Controller
@RequestMapping("/child")
public class ChildController {

	//need to inject child service 
	@Autowired
	private ChildService childService;
	
	
	@GetMapping("/list")
	public String listChildren(Model theModel) {
		
		//get children from the service
		List<Child> theChildren = childService.getChildren();
		
		//add children to the model
		theModel.addAttribute("children",theChildren);
		return "list-children";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Child theChild = new Child();
		theModel.addAttribute("child", theChild);
		
		return "child-form";
	}
	
	
	@PostMapping("/saveChild")
	public String saveChild(@ModelAttribute("child") Child theChild) {
		
		//saving child using service 
		childService.saveChild(theChild);
		
		return "redirect:/child/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("childId") int theId, Model theModel) {
		
		Child theChild = childService.getChild(theId);
		theModel.addAttribute("child", theChild);
		return "child-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteChild(@RequestParam("childId") int theId) {
		childService.deleteChild(theId);
		return "redirect:/child/list";
	}
	
	
	@GetMapping("/search")
	public String searchChild(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		//searching children from the Service
		List<Child> theChildren = childService.searchChild(theSearchName);
		theModel.addAttribute("children",theChildren);
		return "list-children";
	}
	
}
