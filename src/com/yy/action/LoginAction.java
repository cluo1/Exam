package com.yy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Student;
import com.yy.service.StudentService;
import com.yy.service.StudentServiceImpl;
import com.yy.service.TeacherService;
import com.yy.service.TeacherServiceImpl;

public class LoginAction extends ActionSupport {
	private String id; 			// 接受用户编号
	private String password;	// 接受用户密码
	private String role;		// 接受用户角色
	private StudentService studentService = 
		new StudentServiceImpl();//学生业务逻辑组件引用
	private TeacherService teacherService = 
		new TeacherServiceImpl();//教师业务逻辑组件引用
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String execute(){
		if("student".equals(role)){//如果以学生身份登录
			if(studentService.allowLogin(id, password)){
				Student studentInfo = studentService.getStudentInfo(id);
				Map session = ActionContext.getContext().getSession();
				session.put("studentInfo", studentInfo);
				//保存学生记录到session范围
				return "studentSuccess";
			}else{
				addActionError("该学生编号不存在，或者密码不正确!");
				return this.INPUT;
			}
		}else{
			if(teacherService.allowLogin(id, password)){
				return "teacherSuccess";
			}else{
				addActionError("该老师编号不存在，或者密码不正确");
				return this.INPUT;
			}
		}
	}
}
