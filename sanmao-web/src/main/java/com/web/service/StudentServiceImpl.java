package com.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ui.base.DaoHelper;
import com.ui.entity.StudentEntity;
import com.ui.service.fir.FirStudentService;
import com.ui.service.web.WebStudentService;

@Service("webStudentService")
public class StudentServiceImpl implements WebStudentService {

	public static final String namespace = "test_student";
	
	@Resource(name = "writeDaoHelper")
    DaoHelper writeDao;
    @Resource(name = "readDaoHelper")
    DaoHelper readDao;
    
   
    
	@Override
	public void insert(StudentEntity entity) {
		// TODO Auto-generated method stub
		try {  
	        writeDao.insert(namespace, entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<StudentEntity> queryAll(StudentEntity entity)   throws Exception{
		// TODO Auto-generated method stub
		List<StudentEntity> list = readDao.query(namespace, "queryAll", entity);
		return list;
	}

}
