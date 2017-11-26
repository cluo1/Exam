package com.yy.service;

import com.yy.dao.TeacherDao;
import com.yy.dao.TeacherDaoImpl;
import com.yy.entity.Teacher;


public class TeacherServiceImpl implements TeacherService{
	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	public boolean allowLogin(String teacherID, String password) {
		Teacher teacher = teacherDao.findByTeacherID(teacherID);
		if(teacher == null) {//判断是否存在该ID的教师
			return false;
		}else {
			if(password.equals(teacher.getPassword())) {//判断密码是否相同
				return true;
			}else{
				return false;
			}
		}
	}
}
