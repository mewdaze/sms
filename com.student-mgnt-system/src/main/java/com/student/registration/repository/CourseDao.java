package com.student.registration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.student.entity.Course;

public interface CourseDao extends CrudRepository<Course, Integer> {

	List<Course> findByName(String name);

}
