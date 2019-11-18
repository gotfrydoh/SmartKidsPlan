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

import com.hgprojects.smartkidsplan.entity.Schedule;
import com.hgprojects.smartkidsplan.entity.Teacher;
import com.hgprojects.smartkidsplan.service.ScheduleService;
import com.hgprojects.smartkidsplan.service.TeacherService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private TeacherService teacherService;
	
	
	@GetMapping("/list")
	public String listSchedules(Model theModel) {
		List<Schedule> schedules = scheduleService.getSchedules();
		theModel.addAttribute("schedules",schedules);
		return "list-schedules";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Schedule theSchedule = new Schedule();
		List<Teacher> teachers = teacherService.getTeachers();
		theModel.addAttribute("schedule",theSchedule);
		theModel.addAttribute("teachers",teachers);
		return "schedule-form";
	}
	
	@PostMapping("/saveSchedule")
	public String saveSchedule(@ModelAttribute("schedule") Schedule theSchedule) {
		scheduleService.saveSchedule(theSchedule);
		return "redirect:/schedule/list";
	}
	
	@GetMapping("/delete")
	public String deleteSchedule(@RequestParam("scheduleId") int theId) {
		scheduleService.deleteSchedule(theId);
		return "redirect:/schedule/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("scheduleId") int theId, Model theModel) {
		Schedule tempSchedule = scheduleService.getSchedule(theId);
		List<Teacher> teachers = teacherService.getTeachers();
		theModel.addAttribute("schedule",tempSchedule);
		theModel.addAttribute("teachers",teachers);
		return "schedule-form";
	}
	
	@GetMapping("/search")
	public String searchSchedule(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		List<Schedule> schedules = scheduleService.searchSchedule(theSearchName);
		theModel.addAttribute("schedules", schedules);
		return "list-schedules";
	}
	
	
	
}
