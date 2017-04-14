package com.ui.service.fir;

import java.util.List;

import com.ui.entity.StudentEntity;

public interface FirStudentService {

	public void insert(StudentEntity entity);
	
	public List<StudentEntity> queryAll(StudentEntity entity);
}
