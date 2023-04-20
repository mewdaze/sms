package com.student.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Course;
import com.student.entity.Student;
import com.student.registration.service.RegService;

@RestController
public class RegController {
	@Autowired
	RegService regService ;
	
	@PostMapping("/save")
	public String saveData(@RequestBody Student student)
	{
		return regService.saveData(student);
	}
	@PostMapping("/saveCourse")
	public String saveData(@RequestBody Course course)
	{
		return regService.saveCourse(course);
	}
}
