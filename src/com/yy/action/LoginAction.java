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
	private String id; 			// �����û����
	private String password;	// �����û�����
	private String role;		// �����û���ɫ
	private StudentService studentService = 
		new StudentServiceImpl();//ѧ��ҵ���߼��������
	private TeacherService teacherService = 
		new TeacherServiceImpl();//��ʦҵ���߼��������
	
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
		if("student".equals(role)){//�����ѧ����ݵ�¼
			if(studentService.allowLogin(id, password)){
				Student studentInfo = studentService.getStudentInfo(id);
				Map session = ActionContext.getContext().getSession();
				session.put("studentInfo", studentInfo);
				//����ѧ����¼��session��Χ
				return "studentSuccess";
			}else{
				addActionError("��ѧ����Ų����ڣ��������벻��ȷ!");
				return this.INPUT;
			}
		}else{
			if(teacherService.allowLogin(id, password)){
				return "teacherSuccess";
			}else{
				addActionError("����ʦ��Ų����ڣ��������벻��ȷ");
				return this.INPUT;
			}
		}
	}
}
