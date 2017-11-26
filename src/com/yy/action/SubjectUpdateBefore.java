package com.yy.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Subject;
import com.yy.service.SubjectService;
import com.yy.service.SubjectServiceImpl;

public class SubjectUpdateBefore extends ActionSupport{
	private int subjectID;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String execute(){
		Subject subject = subjectService.showSubjectParticular(subjectID);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subject", subject);
		return SUCCESS;
	}
}
