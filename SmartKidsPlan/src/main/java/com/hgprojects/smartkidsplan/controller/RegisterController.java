package com.hgprojects.smartkidsplan.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hgprojects.smartkidsplan.entity.Register;
import com.hgprojects.smartkidsplan.entity.Request;
import com.hgprojects.smartkidsplan.entity.Teacher;
import com.hgprojects.smartkidsplan.service.RegisterService;
import com.hgprojects.smartkidsplan.service.RequestService;
import com.hgprojects.smartkidsplan.service.TeacherService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	//injecting services
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private RequestService requestService;
	
	
	
	
	@GetMapping("/list")
	public String listRegisters(Model theModel) {
		List<Register> registers = registerService.getRegisters();
		theModel.addAttribute("registers",registers);
		return "list-registers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Register theRegister = new Register();
		List<Teacher> teachers = teacherService.getTeachers();
		theModel.addAttribute("register", theRegister);
		theModel.addAttribute("teachers",teachers);
		return "register-form";
	}
	
	@PostMapping("/saveRegister")
	public String saveRegister(@ModelAttribute("register") Register theRegister) {
		registerService.saveRegister(theRegister);
		return "redirect:/register/list";
	}
	
	
	@GetMapping("/delete")
	public String deleteRegister(@RequestParam("registerId") int theId, Model theModel) {
		registerService.deleteRegister(theId);
		return "redirect:/register/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("registerId") int theId,Model theModel) {
		Register theRegister = registerService.getRegister(theId);
		List<Teacher> teachers = teacherService.getTeachers();
		theModel.addAttribute("register",theRegister);
		theModel.addAttribute("teachers",teachers);
		return "register-form";
	}
	
	@GetMapping("/search")
	public String searchRegister(@RequestParam("theSearchName") String theSearchName,Model theModel) {
		List<Register> theRegisters = registerService.searchRegister(theSearchName);
		theModel.addAttribute("registers",theRegisters);
		return "list-registers";
	}
	
	@GetMapping("/showFormForAddTeacher")
	public String showFormForAddTeacher(@RequestParam("registerId") int theId, Model theModel) {
		Register theRegister = registerService.getRegister(theId);
		List<Teacher> teachers = teacherService.getTeachers();
		theModel.addAttribute("register",theRegister);
		theModel.addAttribute("teachers", teachers);
		return "setTeacher-register-form";
	}
	
	@GetMapping("/updateList")
	public String updateList(Model theModel) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 11);
		Date theDate = cal.getTime();
		Date tempDate;
		LocalTime maxEndTime;
		LocalTime startExtraHours = LocalTime.of(16, 0);
		List<Request> selectedRequests = new ArrayList<>();
		List<Request> requests = requestService.getRequestsAfterDate(theDate);
		while(requests.size() > 0) {
			tempDate = requests.get(0).getDateOfAttendance();
			for(int i=0; i<requests.size(); i++) {
				int dateValue = requests.get(i).getDateOfAttendance().compareTo(tempDate);
				if(dateValue == 0) {
					selectedRequests.add(requests.get(i));
					requests.remove(i);
					i--;
				}
			}
			maxEndTime = selectedRequests.get(0).getEndTime();
			for(int i=0; i<selectedRequests.size(); i++) {
				int value = selectedRequests.get(i).getEndTime().compareTo(maxEndTime);
				if(value > 0 ) {
					maxEndTime = selectedRequests.get(i).getEndTime();
				}
			}
			Register tempRegister = new Register("nadgodziny","popoludnie",startExtraHours,maxEndTime,tempDate);
			registerService.saveRegister(tempRegister);
			for(int i=0; i < selectedRequests.size(); i++) {
				selectedRequests.remove(i);
				i--;
				}
		}
		return "redirect:/register/list";
	}
	
	
	@GetMapping("/setTeachersExtraHours")
	public String setTeachersExtraHours(Model theModel) {
		List<Teacher> teachers = teacherService.getTeachers();
		List<Register> nullTeacherRegisters = registerService.getNullTeacherRegisters();
		Teacher minHoursTeacher;
		long minutesWorked;
		
		for(int i=0; i<nullTeacherRegisters.size(); i++) {
			minHoursTeacher = teachers.get(0);
			minutesWorked = minHoursTeacher.countWorkedMinutes();
			for(Teacher tempTeacher : teachers) {
				if(tempTeacher.countWorkedMinutes() < minutesWorked) {
					minHoursTeacher = tempTeacher;
					minutesWorked = tempTeacher.countWorkedMinutes();
				}
			}
			registerService.setTeacherToRegister(nullTeacherRegisters.get(i),minHoursTeacher);
			registerService.saveRegister(nullTeacherRegisters.get(i));
		}
		
		return "redirect:/register/list";
	}
	
	
	
}
