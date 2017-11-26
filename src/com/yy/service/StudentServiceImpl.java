package com.yy.service;

import java.util.List;

import com.yy.dao.StudentDao;
import com.yy.dao.StudentDaoImpl;
import com.yy.entity.Student;

public class StudentServiceImpl implements StudentService{
	private StudentDao studentDao = new StudentDaoImpl();
	public boolean allowLogin(String studentID, String password) {
		Student student = studentDao.findByStudentID(studentID);
		if(student==null){
			return false;			
		}else{
			if(password.equals(student.getPassword())){
				return true;
			}
			return false;
		}
	}
	public Student getStudentInfo(String studentID) {
		return studentDao.findByStudentID(studentID);
	}
	//设置学生成绩
	public void setStudentResult(String studentId, int result) {
		Student student = studentDao.findByStudentID(studentId);
		student.setResult(result);
		studentDao.udateStudent(student);
	}
	//
	public List<Student> getStudentByStudentName(String studentName) {
		return studentDao.findByStudentName(studentName);
	}
	public List<Student> getStudentBySclass(String sclass) {
		return studentDao.findByStudentClass(sclass);
	}
}
