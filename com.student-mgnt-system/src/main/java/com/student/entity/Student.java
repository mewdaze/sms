package com.student.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(length = 50, nullable = false)
	String fname;
	
	@Column(length = 50, nullable = false)
	String lname;
	
	@Column(length = 50, nullable = false, unique = true)
	String mail;
	
	@Column(length = 14, nullable = false, unique = true)
	String mobile;
	
	LocalDate dob;
	
	@Column(length = 14)
	String password;
	
	@Column(length = 10, unique = true)
	String student_id;
	
	String course;
	
	int c_id;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(nullable = false)
	String role;
	
	@CreationTimestamp
	LocalDateTime creationDate;
	
	@UpdateTimestamp
	LocalDateTime updateDate;
	
	boolean status=false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c_id, course, creationDate, dob, fname, id, lname, mail, mobile, password, status,
				student_id, updateDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return c_id == other.c_id && Objects.equals(course, other.course)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(dob, other.dob)
				&& Objects.equals(fname, other.fname) && id == other.id && Objects.equals(lname, other.lname)
				&& Objects.equals(mail, other.mail) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(password, other.password) && status == other.status
				&& Objects.equals(student_id, other.student_id) && Objects.equals(updateDate, other.updateDate);
	}
	
	
}
