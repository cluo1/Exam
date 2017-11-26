package com.yy.service;

import java.util.List;

import com.yy.dao.SubjectDao;
import com.yy.dao.SubjectDaoImp;
import com.yy.entity.Subject;
import com.yy.util.Page;
import com.yy.util.PageResult;
import com.yy.util.PageUtil;

public class SubjectServiceImpl implements SubjectService {
	SubjectDao subjectDao = new SubjectDaoImp();
	public List<Subject> randomFindSubject(int number) {
		return subjectDao.randomFindSubject(number);
	}
	//根据考试结果计算成绩
	public int accountResult(List<Integer> subjectIDs,
			List<String> subjectAnswers) {
		int GeneralPoint = 0;
		for(int i=0;i<subjectIDs.size();i++){
			Subject subject = subjectDao.findSubjectByID(subjectIDs.get(i));
			String rightAnswers = subject.getSubjectAnswer();
			if(rightAnswers.equals(subjectAnswers.get(i))){
				GeneralPoint+=5;
			}
		}
		return GeneralPoint;
	}
	public Subject showSubjectParticular(int subjectId) {
		return subjectDao.findSubjectByID(subjectId);
	}
	public PageResult findSubjectByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(), subjectDao.findSubjectCount(), page.getCurrentPage());
		//System.out.println(page.getEveryPage());
		List<Subject> list = subjectDao.findSubjectByPage(page);
		//System.out.println(list);
		PageResult pageResult= new PageResult();
		pageResult.setPage(page);
		pageResult.setList(list);
		return pageResult;
	}
	public void updateSubject(Subject subject) {
		subjectDao.updateSubject(subject);
	}
	public void deleteSubject(int subjectID) {
		subjectDao.deleteSubject(subjectID);
	}
	public PageResult likeQueryBySubjectTitle(String subjectTitle, Page page) {
		page = PageUtil.createPage(page.getEveryPage(), subjectDao.findLikeQueryCount(subjectTitle), page.getCurrentPage());
		List<Subject> list = subjectDao.likeQueryByTitle(subjectTitle, page);
		PageResult result = new PageResult();
		result.setList(list);
		result.setPage(page);
		return result;
	}
	public boolean saveSubject(Subject subject) {
		String title = subject.getSubjectTitle();
		if(subjectDao.findSubjectByTitle(title) == null){
			subjectDao.addSubject(subject);
			return true;
		}
		return false;
	}
}
