package com.yy.service;

import java.util.List;

import com.yy.entity.Student;

public interface StudentService {
	//判断是否为合法学生，从而决定是否允许登录
	public boolean allowLogin(String studentID,String password);
	//获得学生信息
	public Student getStudentInfo(String studentID);
	
	//设置学生成绩
	public void setStudentResult(String studentId,int result);
	//由学生姓名获取学生信息
	public List<Student> getStudentByStudentName(String studentName);
	//由学生班级获取学生信息
	public List<Student> getStudentBySclass(String sclass);
}
