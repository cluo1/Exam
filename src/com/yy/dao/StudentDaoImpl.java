package com.yy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yy.entity.Student;
import com.yy.util.HibernateSessionFactory;

public class StudentDaoImpl implements StudentDao {

	public Student findByStudentID(String studentID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return student;
	}
	//����
	public void udateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction transaction = null;//��������
		try {
			transaction = session.beginTransaction();//��������
			session.update(student);
			transaction.commit();//�ύ����
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();//����ع�
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
