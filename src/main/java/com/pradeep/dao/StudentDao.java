package com.pradeep.dao;

import java.util.List;

import com.pradeep.model.Student;

public interface StudentDao {

	public List<Student> getAllStudent();

	public void addStudent(Student student);

	public void deleteStudent(Integer studentId);

	public Student updateStudent(Student student);

	public Student getStudent(int studentid);
	
	 
	
	public List<Student> getStudentByName(String name) throws Exception;
}
