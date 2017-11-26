package com.yy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Subject;
import com.yy.service.SubjectService;
import com.yy.service.SubjectServiceImpl;
import com.yy.util.Page;
import com.yy.util.PageResult;

public class LikeQuerySubjeceAction extends ActionSupport{
	private int currentPage;
	private String subjectTitle;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public String execute(){
		Page page = new Page();
		page.setCurrentPage(currentPage);
		PageResult result = subjectService.likeQueryBySubjectTitle(subjectTitle, page);
		List<Subject> subjects = result.getList();
		List<Subject> newSubjects = new ArrayList<Subject>();//新的记录
		//给关键字标红
		for(Subject subject : subjects){
			String newTitle = subject.getSubjectTitle().replaceAll(subjectTitle,
						"<font color='red'>" + subjectTitle + "</font>");
			subject.setSubjectTitle(newTitle);
			newSubjects.add(subject);
		}
		page = result.getPage();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", newSubjects);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
