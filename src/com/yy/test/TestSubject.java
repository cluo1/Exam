package com.yy.test;

import org.hibernate.Session;

import com.yy.entity.Subject;
import com.yy.util.HibernateSessionFactory;

public class TestSubject {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Subject s = (Subject) session.get(Subject.class, 2);
		System.out.println(s.getSubjectTitle());
	}
}
