package com.student.registration.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.entity.Student;

public interface RegDao extends CrudRepository<Student, Integer>{

}
