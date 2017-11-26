package com.yy.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Student;
import com.yy.service.StudentService;
import com.yy.service.StudentServiceImpl;
import com.yy.service.SubjectService;
import com.yy.service.SubjectServiceImpl;

public class SubmitExamAction extends ActionSupport{
	private List<Integer> subjectID;//学生考试的题目
	private SubjectService subjectService = new SubjectServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	public List<Integer> getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(List<Integer> subjectID) {
		this.subjectID = subjectID;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> subjectAnswers = new ArrayList<String>();
		for(int i=0;i<20;i++){
			String answer = request.getParameter("subjectAnswer"+i);
			subjectAnswers.add(answer);
		}
		int GeneralPoint = subjectService.accountResult(subjectID, subjectAnswers);
		//设置成绩到学生信息中
		Map session = ActionContext.getContext().getSession();
		Student student = (Student) session.get("studentInfo");		
		studentService.setStudentResult(student.getStudentID(),GeneralPoint);
		request.setAttribute("studentName",student.getStudentName());
		request.setAttribute("GeneralPoint",GeneralPoint);//保存学生信息
		session.put("subjectIDs", subjectID);//将考试题目保存到session，方便后面显示答案使用
		return SUCCESS;
	}
}
