package com.yy.service;

import java.util.List;

import com.yy.entity.Student;

public interface StudentService {
	//�ж��Ƿ�Ϊ�Ϸ�ѧ�����Ӷ������Ƿ������¼
	public boolean allowLogin(String studentID,String password);
	//���ѧ����Ϣ
	public Student getStudentInfo(String studentID);
	
	//����ѧ���ɼ�
	public void setStudentResult(String studentId,int result);
	//��ѧ��������ȡѧ����Ϣ
	public List<Student> getStudentByStudentName(String studentName);
	//��ѧ���༶��ȡѧ����Ϣ
	public List<Student> getStudentBySclass(String sclass);
}
