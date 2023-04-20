package com.student.login.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.entity.LogIn;
import com.student.entity.Student;

@Service
public interface LogInService {

	ResponseEntity<Object> setData(Student student);

}
