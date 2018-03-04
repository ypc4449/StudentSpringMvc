package com.pradeep.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pradeep.dao.StudentDao;
import com.pradeep.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory session;
	
	public void addStudent(Student student) {
        session.getCurrentSession().saveOrUpdate(student);
 
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		return session.getCurrentSession().createQuery("from Student").list();
	}

	@Override
	public void deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		Student student = (Student) session.getCurrentSession().load(
                Student.class, studentId);
        if (null != student) {
            this.session.getCurrentSession().delete(student);
        }
 
    }
		
	

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(student);
        return student;
	}

	@Override
	public Student getStudent(int studentid) {
		// TODO Auto-generated method stub
		return (Student) session.getCurrentSession().get(
                Student.class, studentid);
	}
	 

	@Override
	@Transactional
	public List<Student> getStudentByName(String name)  throws Exception{
		// TODO Auto-generated method stub
		String sql="from Student  where firstname LIKE :name";
		Query query=session.getCurrentSession().createQuery(sql);
		query.setString("name", "%"+name+"%");
		return query .list();
	}
}


