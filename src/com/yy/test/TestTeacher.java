package com.yy.test;

import org.hibernate.Session;
import org.junit.Test;

import com.yy.entity.Teacher;
import com.yy.util.HibernateSessionFactory;

public class TestTeacher {
	@Test
	public void findById(){
		Session session = HibernateSessionFactory.getSession();
		Teacher teacher = (Teacher) session.get(Teacher.class, 1);
		System.out.println(teacher.getTeacherID());
	}
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Teacher teacher = (Teacher) session.get(Teacher.class, "teacher");
		System.out.println(teacher.getPassword());
	}
}
