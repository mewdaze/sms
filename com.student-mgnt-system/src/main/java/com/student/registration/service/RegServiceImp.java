package com.student.registration.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Course;
import com.student.entity.Student;
import com.student.registration.repository.CourseDao;
import com.student.registration.repository.RegDao;

//import com.student.registration.repository.RegRepository;

@Service
public class RegServiceImp implements RegService {

//	@Autowired
//	RegRepository  regRepository;

	@Autowired
	EntityManager entityManager;

	@Autowired
	RegDao regDao;

	@Autowired
	CourseDao courseDao;

	@Override
	public String saveData(Student student) {
//		String SQL="select course_id, name from course where name='"+student.getCourse_id()+"'
//		List<Course> courseList=entityManager.createNativeQuery(SQL,Course.class).getResultList();
		
		List<Course> cList =courseDao.findByName(student.getCourse());
		cList.forEach(course->{
			System.out.println(course.getCourseId()+" "+course.getName());
			student.setC_id(course.getCourseId());
		});
		String SQL= "SELECT * FROM student_db.hibernate_sequence;";
		List<Student> s_id=entityManager.createNativeQuery(SQL).getResultList();
		System.out.println(s_id.get(0));
		Student id=s_id.get(0);
		regDao.save(student);
		return "Data Inserted Successfully";
	}

	@Override
	public String saveCourse(Course course) {
		courseDao.save(course);
		return "Course Inserted Successfully";
	}

}
