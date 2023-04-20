package com.student.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.login.service.LogInService;

@RestController
public class LogInController {
	@Autowired
	LogInService logInService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> setData(@RequestBody Student student)
	{
		return logInService.setData(student);
	}
}
