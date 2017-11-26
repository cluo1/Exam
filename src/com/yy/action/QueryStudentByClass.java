package com.yy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Student;
import com.yy.service.StudentService;
import com.yy.service.StudentServiceImpl;

public class QueryStudentByClass extends ActionSupport {
	private StudentService studentService= new StudentServiceImpl();
	private String sclass;
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String execute(){
		List<Student> students = studentService.getStudentBySclass(sclass);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);
		return SUCCESS;
	}
}
