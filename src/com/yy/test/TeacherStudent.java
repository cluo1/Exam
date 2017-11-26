package com.yy.test;

import org.hibernate.Session;

import com.yy.entity.Student;
import com.yy.util.HibernateSessionFactory;

public class TeacherStudent {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Student s = (Student) session.get(Student.class, "001");
		System.out.println(s.getStudentName());
	}
}
