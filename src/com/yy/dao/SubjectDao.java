package com.yy.dao;

import java.util.List;

import com.yy.entity.Subject;
import com.yy.util.Page;

public interface SubjectDao {
	public List<Subject> randomFindSubject(int number);//随机取出记录
	public Subject findSubjectByID(int subjectId);//根据试题ID查找试题
	public int findSubjectCount();//查询所有试题数目
	public List<Subject> findSubjectByPage(Page page);//根据分页信息查询试题记录
	public void updateSubject(Subject subject);//更新试题
	public void deleteSubject(int subjectID);//根据试题ID删除试题
	public int findLikeQueryCount(String subjectTitle);//模糊查询记录数
	public List<Subject> likeQueryByTitle(String subjectTitle,Page page);//根据试题标题模糊查询试题
	public void addSubject(Subject subject);//添加试题
	public Subject findSubjectByTitle(String subjectTitle);//根据试题标题查找试题
}
