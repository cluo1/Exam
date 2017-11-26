package com.yy.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.entity.Subject;
import com.yy.service.SubjectService;
import com.yy.service.SubjectServiceImpl;

/*
 * œ‘ æ ‘Ã‚¥∞∏
 */
public class ShowSubjectAnswer extends ActionSupport{
	private SubjectService subjectService = new SubjectServiceImpl();
	private List<Subject> subjects = new ArrayList<Subject>();
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		List<Integer> subjectIds = (List<Integer>) session.get("subjectIDs");	
		for(int i=0;i<subjectIds.size();i++){
			Subject subject = subjectService.showSubjectParticular(subjectIds.get(i));
			subjects.add(subject);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects",subjects);
		return SUCCESS;
	}
}
