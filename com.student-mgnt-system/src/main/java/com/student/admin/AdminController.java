package com.student.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/approved")
	public ResponseEntity<Object> approvedStudents()
	{
		return adminService.approvedStudents();
	}
	
	@GetMapping("/notApproved")
	public ResponseEntity<Object> notApprovedStudents()
	{
		return adminService.notApprovedStudents();
	}
}
