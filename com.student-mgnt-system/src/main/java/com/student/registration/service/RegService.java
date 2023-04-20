package com.student.registration.service;

import org.springframework.stereotype.Service;

import com.student.entity.Course;
import com.student.entity.Student;

@Service
public interface RegService {

	String saveData(Student student);

	String saveCourse(Course course);

}
