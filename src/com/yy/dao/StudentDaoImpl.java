package com.yy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yy.entity.Student;
import com.yy.util.HibernateSessionFactory;

public class StudentDaoImpl implements StudentDao {

	public Student findByStudentID(String studentID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();//关闭Session对象
		return student;
	}
	//更新
	public void udateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction transaction = null;//声明事务
		try {
			transaction = session.beginTransaction();//开启事务
			session.update(student);
			transaction.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();
	}
	public List<Student> findByStudentName(String name) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student as stu where stu.studentName=?");
		query.setString(0, name);
		List<Student> students = query.list();
		return students;
	}
	public List<Student> findByStudentClass(String sclass) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student as stu where stu.sclass=?");
		query.setString(0, sclass);
		List<Student> students = query.list();
		return students;
	}
}
