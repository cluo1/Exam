package com.yy.dao;

import java.util.List;

import com.yy.entity.Student;
public interface StudentDao {
	public Student findByStudentID(String studentID);//��ѯ����������ѧ��ID��ѯ
	//����ѧ����Ϣ
	public void udateStudent(Student student);
	//ͨ����������ѧ����Ϣ
	public List<Student> findByStudentName(String name);
	//ͨ���༶����ѧ����Ϣ
	public List<Student> findByStudentClass(String sclass);
}
