package com.yy.service;

import com.yy.dao.TeacherDao;
import com.yy.dao.TeacherDaoImpl;
import com.yy.entity.Teacher;


public class TeacherServiceImpl implements TeacherService{
	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	public boolean allowLogin(String teacherID, String password) {
		Teacher teacher = teacherDao.findByTeacherID(teacherID);
		if(teacher == null) {//�ж��Ƿ���ڸ�ID�Ľ�ʦ
			return false;
		}else {
			if(password.equals(teacher.getPassword())) {//�ж������Ƿ���ͬ
				return true;
			}else{
				return false;
			}
		}
	}
}
