package com.yy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Student;
import com.yy.service.StudentService;
import com.yy.service.StudentServiceImpl;

public class QueryStudentByName extends ActionSupport{
	private String studentName;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	private StudentService studentService = new StudentServiceImpl();
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student> students = studentService.getStudentByStudentName(studentName);
		request.setAttribute("students", students);
		return SUCCESS;
	}
}
