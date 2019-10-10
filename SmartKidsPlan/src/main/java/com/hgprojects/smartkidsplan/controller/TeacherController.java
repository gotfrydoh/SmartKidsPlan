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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hgprojects.smartkidsplan.entity.Group;
import com.hgprojects.smartkidsplan.entity.Teacher;
import com.hgprojects.smartkidsplan.service.GroupService;
import com.hgprojects.smartkidsplan.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	//need to inject teacher service
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private GroupService groupService;
	
	@GetMapping("/list")
	public String listTeachers(Model theModel) {
		//get teachers from the service
		List<Teacher> theTeachers = teacherService.getTeachers();
		//add teachers to the model
		theModel.addAttribute("teachers",theTeachers);
		return "list-teachers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Teacher theTeacher = new Teacher();
		theModel.addAttribute("teacher",theTeacher);
		return "teacher-form";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher theTeacher) {
		//saving teacher using service
		teacherService.saveTeacher(theTeacher);
		return "redirect:/teacher/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("teacherId") int theId, Model theModel) {
		Teacher theTeacher = teacherService.getTeacher(theId);
		theModel.addAttribute("teacher",theTeacher);
		return "teacher-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteTeacher(@RequestParam("teacherId") int theId) {
		teacherService.deleteTeacher(theId);
		return "redirect:/teacher/list";
	}
	
	
	@GetMapping("/search")
	public String searchTeacher(@RequestParam("theSearchName") String theSearchName,Model theModel) {
		//searching teachers from the service
		List<Teacher> theTeachers = teacherService.searchTeacher(theSearchName);
		theModel.addAttribute("teachers",theTeachers);
		return "list-teachers";
	}
	
	@GetMapping("/showFormForAddGroup")
	public String showFormForAddGroup(@RequestParam("teacherId") int theId, Model theModel) {
		Teacher theTeacher = teacherService.getTeacher(theId);
		List<Group> allGroups = groupService.getGroups();
		List<Group> teacherGroups = theTeacher.getGroups(); //moze nie dzialac bo nie jest w service
		for(int i=0; i<teacherGroups.size();i++) {
			for(int j=0; j<allGroups.size();j++) {
				if(teacherGroups.get(i).getId()==allGroups.get(j).getId()) {
					allGroups.remove(j);
					j--;
				}
			}	
		}
		theModel.addAttribute("allGroups",allGroups);
		theModel.addAttribute("teacherGroups",teacherGroups);
		theModel.addAttribute("theTeacher", theTeacher);
		return "addGroup-teacher-form";
	}
	
	
	@GetMapping("/addGroupToTeacher")
	public String addGroupToTeacher(@RequestParam("teacherId") int teacherId, @RequestParam("groupId") int groupId, Model theModel,RedirectAttributes redirectAttrs) {
		teacherService.addGroupToTeacher(teacherId,groupId);
		redirectAttrs.addAttribute("teacherId",teacherId);
		return "redirect:/teacher/showFormForAddGroup?teacherId={teacherId}";
	}
	
	
	@GetMapping("/removeGroupFromTeacher")
	public String removeGroupFromTeacher(@RequestParam("teacherId") int teacherId, @RequestParam("groupId") int groupId, Model theModel, RedirectAttributes redirectAttrs) {
		teacherService.removeGroupFromTeacher(teacherId,groupId);
		redirectAttrs.addAttribute("teacherId", teacherId);
		return "redirect:/teacher/showFormForAddGroup?teacherId={teacherId}";
	}
	
}
