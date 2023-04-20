package com.student.admin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.entity.Student;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public ResponseEntity<Object> approvedStudents() {
		Map<String, Object> response = new HashMap<>();
		String SQL="select * from student where role='student';";
		List<Student> li = entityManager.createNativeQuery(SQL, Student.class).getResultList();
		for(int i=0;i<li.size();i++)
		{
			if(!li.isEmpty() && li.get(i).isStatus())
			{
				response.put("status", "ok");
				response.put("message", "Approved Students");
				response.put("data", li.get(i));
			}
			else
			{
				response.put("status", "error");
				response.put("message", "Failed to load Approved Students");
			}
		}
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> notApprovedStudents() {
		Map<String, Object> response = new LinkedHashMap<>();
		String SQL="select * from student where role='student' and status=0";
		List<Student> li = entityManager.createNativeQuery(SQL, Student.class).getResultList();
			if((!li.isEmpty()))
			{
				response.put("status", "ok");
				response.put("message", "Not Approved Students");
				response.put("count", li.size());
				response.put("data", li);
			}
			else
			{
				response.put("status", "error");
				response.put("message", "Failed to load Not Approved Students");
			}
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
}
