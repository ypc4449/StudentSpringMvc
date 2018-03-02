package com.pradeep.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pradeep.dao.StudentDao;
import com.pradeep.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory session;

	@Override
	public List<Student> getAllStudent() {
		return session.getCurrentSession().createQuery("from Student").list();
	}

}
