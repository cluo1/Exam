package com.yy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.yy.entity.Subject;
import com.yy.util.HibernateSessionFactory;
import com.yy.util.Page;

public class SubjectDaoImp implements SubjectDao{
	//���ȡ����¼�õ�����
	public List<Subject> randomFindSubject(int number) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub order by rand()");
		query.setMaxResults(number);//���ò�ѯ��¼��
		//����¼������浽list��
		List<Subject> list = query.list();
		//�ر�session
		HibernateSessionFactory.closeSession();
		return list;
	}
	//����ID��ѯ��¼�õ�����𰸼���ɼ�
	public Subject findSubjectByID(int subjectId) {
		Session session = HibernateSessionFactory.getSession();
		Subject subject = (Subject) session.get(Subject.class, subjectId);
		HibernateSessionFactory.closeSession();
		return subject;
	}
	//��ҳ��ѯ
	public List<Subject> findSubjectByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject");
		query.setMaxResults(page.getEveryPage());//����ÿҳ�����¼��
		query.setFirstResult(page.getBeginIndex());//������ʼ��¼
		List<Subject> list = query.list();//����ѯ������浽list��
		HibernateSessionFactory.closeSession();
		return list;
	}
	//��ѯ�����¼
	public int findSubjectCount() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject");
		List<Subject> list = query.list();
		int count = list.size();
		//System.out.println("size:"+count);
		HibernateSessionFactory.closeSession();
		return count;
	}
	//��������
	public void updateSubject(Subject subject) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		try {
			session.update(subject);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}
	public void deleteSubject(int subjectID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Subject subject = (Subject) session.get(Subject.class, subjectID);
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.delete(subject);
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}
	//ģ����ѯ������
	public int findLikeQueryCount(String subjectTitle) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like :title");
		query.setString("title", "%"+subjectTitle+"%");
		List list = query.list();
		int count = list.size();
		HibernateSessionFactory.closeSession();
		return count;
	}
	public List<Subject> likeQueryByTitle(String subjectTitle, Page page) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like :title");
		query.setString("title", "%"+subjectTitle+"%");
		query.setMaxResults(page.getEveryPage());//����ÿҳ�ļ�¼��
		query.setFirstResult(page.getBeginIndex());//������ʼλ��
		List<Subject> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	public void addSubject(Subject subject) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		try{
			session.save(subject);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	public Subject findSubjectByTitle(String subjectTitle) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle = ?");
		query.setString(0, subjectTitle);
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		if(list.size() == 0) {
			return null;							//����null
		}else {
			return (Subject) list.get(0);			//���ص�һ������
		}
	}
}
