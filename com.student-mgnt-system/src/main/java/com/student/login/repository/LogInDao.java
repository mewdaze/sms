package com.student.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.entity.Student;

public interface LogInDao extends CrudRepository<Student, Integer>{

}
