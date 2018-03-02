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

}
