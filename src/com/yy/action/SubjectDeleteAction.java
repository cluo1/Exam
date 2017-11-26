package com.yy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.service.SubjectService;
import com.yy.service.SubjectServiceImpl;

public class SubjectDeleteAction extends ActionSupport{
	private int subjectID;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String execute() throws Exception {
		subjectService.deleteSubject(subjectID);
		return SUCCESS;
	}
}
