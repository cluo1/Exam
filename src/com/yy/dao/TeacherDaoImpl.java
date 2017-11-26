package com.yy.dao;

import org.hibernate.Session;

import com.yy.entity.Teacher;
import com.yy.util.HibernateSessionFactory;

public class TeacherDaoImpl implements TeacherDao {
	public Teacher findByTeacherID(String teacherID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Teacher teacher = (Teacher) session.get(Teacher.class, teacherID);
		HibernateSessionFactory.closeSession();//关闭Session对象
		return teacher;
	}
}
