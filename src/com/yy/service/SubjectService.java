package com.yy.service;

import java.util.List;

import com.yy.entity.Subject;
import com.yy.util.Page;
import com.yy.util.PageResult;

public interface SubjectService {
	public List<Subject> randomFindSubject(int number);	
	public int accountResult(List<Integer>subjectIDs,List<String>studentAnswers);
	public Subject showSubjectParticular(int subjectId);
	//��ҳ��ѯ
	public PageResult findSubjectByPage(Page page);
	//��������
	public void updateSubject(Subject subject);
	// ɾ��������Ϣ
	public void deleteSubject(int subjectID);
	//ģ����ѯ������Ϣ
	public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);
	//�ж��Ƿ�����������
	public boolean saveSubject(Subject subject);
}