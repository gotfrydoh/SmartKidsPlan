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

import com.hgprojects.smartkidsplan.entity.Group;
import com.hgprojects.smartkidsplan.entity.Teacher;
import com.hgprojects.smartkidsplan.service.GroupService;
import com.hgprojects.smartkidsplan.service.TeacherService;

@Controller
@RequestMapping("/group")
public class GroupController {

	//need to inject group Service
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/list")
	public String listGroups(Model theModel) {
		//getting groups from DB 
		List<Group> groups = groupService.getGroups();
		theModel.addAttribute("groups",groups);
		return "list-groups";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Group theGroup = new Group();
		theModel.addAttribute("group",theGroup);
		List<Teacher> teachers =teacherService.getTeachers();
		theModel.addAttribute("teachers", teachers);
		return "group-form";
	}
	
	@PostMapping("/saveGroup")
	public String saveGroup(@ModelAttribute("group") Group theGroup) {
		groupService.saveGroup(theGroup);
		return "redirect:/group/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("groupId") int groupId) {
		groupService.deleteGroup(groupId);
		return "redirect:/group/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("groupId") int groupId, Model theModel) {
		Group theGroup = groupService.getGroup(groupId);
		List<Teacher> theTeachers = teacherService.getTeachers();
		theModel.addAttribute("group", theGroup);
		theModel.addAttribute("teachers",theTeachers);
		return "group-form";
	}
	
	@GetMapping("/search")
	public String searchGroup(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		List<Group> groups = groupService.searchGroup(theSearchName);
		theModel.addAttribute("groups", groups);
		return "list-groups";
	}
	
	
	
}
