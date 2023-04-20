package com.student.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

	ResponseEntity<Object> approvedStudents();

	ResponseEntity<Object> notApprovedStudents();
}
