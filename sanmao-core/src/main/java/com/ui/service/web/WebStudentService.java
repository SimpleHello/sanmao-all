package com.ui.service.web;

import java.util.List;

import com.ui.entity.StudentEntity;

public interface WebStudentService {

	public void insert(StudentEntity entity);
	
	public List<StudentEntity> queryAll(StudentEntity entity)  throws Exception;
}
