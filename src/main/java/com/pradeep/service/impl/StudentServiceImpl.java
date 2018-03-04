package com.pradeep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pradeep.dao.StudentDao;
import com.pradeep.model.Student;
import com.pradeep.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Transactional
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);

	}

	@Override
	@Transactional
	public void deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(studentId);

	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub

		return studentDao.updateStudent(student);
		
	}

	@Override
	@Transactional
	public Student getStudent(int studentid) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentid);
	}

	@Override
	public List<Student> getStudentByName(String name) throws Exception {
		// TODO Auto-generated method stub
	return studentDao.getStudentByName(name);
	}

	
}
