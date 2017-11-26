package com.yy.dao;

import com.yy.entity.Teacher;


public interface TeacherDao {
	public Teacher findByTeacherID(String teacherID);//查询方法，根据教师ID查询
}
