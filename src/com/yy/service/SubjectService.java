package com.yy.service;

import java.util.List;

import com.yy.entity.Subject;
import com.yy.util.Page;
import com.yy.util.PageResult;

public interface SubjectService {
	public List<Subject> randomFindSubject(int number);	
	public int accountResult(List<Integer>subjectIDs,List<String>studentAnswers);
	public Subject showSubjectParticular(int subjectId);
	//分页查询
	public PageResult findSubjectByPage(Page page);
	//更新试题
	public void updateSubject(Subject subject);
	// 删除试题信息
	public void deleteSubject(int subjectID);
	//模糊查询试题信息
	public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);
	//判断是否可以添加试题
	public boolean saveSubject(Subject subject);
}