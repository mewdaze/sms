package com.student.login.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.entity.LogIn;
import com.student.entity.Student;

@Service
public class LogInServiceImp implements LogInService {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public ResponseEntity<Object> setData(Student student) {
		Map<String, Object> response=new LinkedHashMap<>();
		String SQL="select * from student where mail='"+student.getMail()+"'";
		List<Student> li = entityManager.createNativeQuery(SQL, Student.class).getResultList();
		li.forEach(s->{System.out.println(s.getMail()+" "+s.getPassword()+" "+s.isStatus());});
		if(!li.isEmpty() && student.getMail().equals(li.get(0).getMail()))
		{
			if(student.getPassword().equals(li.get(0).getPassword()))
			{
				if(li.get(0).isStatus())
				{
					response.put("status","ok");
					response.put("message", "Log in Successfull");
					response.put("data", li);
				}
				else
				{
					response.put("status", "error");
					response.put("message", "Log in not Approved. Contact admin.");
				}
			}
			else
			{
				response.put("status", "error");
				response.put("message", "Invalid Password");
			}
		}
		else
		{
			response.put("status", "error");
			response.put("message", "Invalid Log in id");
		}
		return new ResponseEntity<Object> (response,HttpStatus.OK);
	}

}
