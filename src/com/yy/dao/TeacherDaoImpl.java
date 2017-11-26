package com.yy.dao;

import org.hibernate.Session;

import com.yy.entity.Teacher;
import com.yy.util.HibernateSessionFactory;

public class TeacherDaoImpl implements TeacherDao {
	public Teacher findByTeacherID(String teacherID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Teacher teacher = (Teacher) session.get(Teacher.class, teacherID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return teacher;
	}
}
