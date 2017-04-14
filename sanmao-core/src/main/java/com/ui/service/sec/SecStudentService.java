package com.ui.service.sec;

import java.util.List;

import com.ui.entity.StudentEntity;

public interface SecStudentService {

	public void insert(StudentEntity entity);
	
	public List<StudentEntity> queryAll(StudentEntity entity);
}
