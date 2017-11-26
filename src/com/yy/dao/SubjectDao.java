package com.yy.dao;

import java.util.List;

import com.yy.entity.Subject;
import com.yy.util.Page;

public interface SubjectDao {
	public List<Subject> randomFindSubject(int number);//���ȡ����¼
	public Subject findSubjectByID(int subjectId);//��������ID��������
	public int findSubjectCount();//��ѯ����������Ŀ
	public List<Subject> findSubjectByPage(Page page);//���ݷ�ҳ��Ϣ��ѯ�����¼
	public void updateSubject(Subject subject);//��������
	public void deleteSubject(int subjectID);//��������IDɾ������
	public int findLikeQueryCount(String subjectTitle);//ģ����ѯ��¼��
	public List<Subject> likeQueryByTitle(String subjectTitle,Page page);//�����������ģ����ѯ����
	public void addSubject(Subject subject);//�������
	public Subject findSubjectByTitle(String subjectTitle);//������������������
}
