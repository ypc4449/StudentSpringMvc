package com.pradeep.service;

import java.util.List;

import com.pradeep.model.Student;

public interface StudentService {

	public List<Student> getAllStudent();

	public void addStudent(Student student);

	public void deleteStudent(Integer studentId);

	public Student updateStudent(Student student);

	public Student getStudent(int studentid);
	
	public List<Student> getStudentByName(String name) throws Exception;
}