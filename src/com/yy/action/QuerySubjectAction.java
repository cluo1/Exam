package com.yy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Subject;
import com.yy.service.SubjectService;
import com.yy.service.SubjectServiceImpl;
import com.yy.util.Page;
import com.yy.util.PageResult;

public class QuerySubjectAction extends ActionSupport{
	private int currentPage;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String execute(){
		Page page = new Page();
		//page.setEveryPage(10);
		page.setCurrentPage(currentPage);
		PageResult result = subjectService.findSubjectByPage(page);
		List<Subject> subjects = result.getList();
		//System.out.println(subjects);
		page = result.getPage();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
