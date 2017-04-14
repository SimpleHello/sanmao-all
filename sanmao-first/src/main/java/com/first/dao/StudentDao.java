package com.first.dao;

import java.util.List;

import com.ui.entity.StudentEntity;

public interface StudentDao {
	
	public void insert(StudentEntity entity);
	
	public List<StudentEntity> queryAll(StudentEntity entity);
}
