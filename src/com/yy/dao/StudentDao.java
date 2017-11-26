package com.yy.dao;

import java.util.List;

import com.yy.entity.Student;
public interface StudentDao {
	public Student findByStudentID(String studentID);//查询方法，根据学生ID查询
	//更新学生信息
	public void udateStudent(Student student);
	//通过姓名查找学生信息
	public List<Student> findByStudentName(String name);
	//通过班级查找学生信息
	public List<Student> findByStudentClass(String sclass);
}
