package com.yy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.yy.entity.Subject;
import com.yy.util.HibernateSessionFactory;
import com.yy.util.Page;

public class SubjectDaoImp implements SubjectDao{
	//随机取出记录得到试题
	public List<Subject> randomFindSubject(int number) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub order by rand()");
		query.setMaxResults(number);//设置查询记录数
		//将记录结果保存到list中
		List<Subject> list = query.list();
		//关闭session
		HibernateSessionFactory.closeSession();
		return list;
	}
	//根据ID查询记录得到试题答案计算成绩
	public Subject findSubjectByID(int subjectId) {
		Session session = HibernateSessionFactory.getSession();
		Subject subject = (Subject) session.get(Subject.class, subjectId);
		HibernateSessionFactory.closeSession();
		return subject;
	}
	//分页查询
	public List<Subject> findSubjectByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject");
		query.setMaxResults(page.getEveryPage());//设置每页试题记录数
		query.setFirstResult(page.getBeginIndex());//设置起始记录
		List<Subject> list = query.list();//将查询结果保存到list中
		HibernateSessionFactory.closeSession();
		return list;
	}
	//查询试题记录
	public int findSubjectCount() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject");
		List<Subject> list = query.list();
		int count = list.size();
		//System.out.println("size:"+count);
		HibernateSessionFactory.closeSession();
		return count;
	}
	//更新试题
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
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Subject subject = (Subject) session.get(Subject.class, subjectID);
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.delete(subject);
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
	//模糊查询试题数
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
		query.setMaxResults(page.getEveryPage());//设置每页的记录数
		query.setFirstResult(page.getBeginIndex());//设置起始位置
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
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle = ?");
		query.setString(0, subjectTitle);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();		//关闭Session对象
		if(list.size() == 0) {
			return null;							//返回null
		}else {
			return (Subject) list.get(0);			//返回第一个试题
		}
	}
}
