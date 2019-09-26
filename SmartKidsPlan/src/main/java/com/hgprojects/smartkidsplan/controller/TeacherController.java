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

import com.hgprojects.smartkidsplan.entity.Teacher;
import com.hgprojects.smartkidsplan.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	//need to inject teacher service
	@Autowired
	private TeacherService teacherService;
	
	
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
	
	
	
}
