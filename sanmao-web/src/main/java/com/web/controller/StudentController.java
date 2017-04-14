package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ui.base.JSONUtil;
import com.ui.base.JsonMap;
import com.ui.entity.StudentEntity;
import com.ui.service.fir.FirStudentService;
import com.ui.service.web.WebStudentService;

@Controller
public class StudentController {

	@Resource(name="webStudentService")
	private WebStudentService webStudentService;
	
	@Resource(name="firStudentService")
	private FirStudentService firStudentService;
	
	@RequestMapping("/student/insert.do")
	public @ResponseBody Map<String,Object> getDeptList() {
		// TODO Auto-generated method stub
		StudentEntity in = new StudentEntity();
		in.setName("张三 web");
		in.setAge(100);
		webStudentService.insert(in);
		System.out.println("成功 插入了  web 数据");
		in.setName("张三 first");
		in.setAge(25);
		firStudentService.insert(in);
		System.out.println("成功 插入了  first 数据");
		Map<String,Object> map =JsonMap.resultMap(1, "ok", null);
		return map;
	}
	
	@RequestMapping("/student/queryAll.do")
	public @ResponseBody String queryAll() throws Exception {
		// TODO Auto-generated method stub
		StudentEntity in = new StudentEntity();
		List<StudentEntity> list = webStudentService.queryAll(in);
		int total = list.size();
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", list);
		map.put("page", 2);
		return JSONUtil.toJsonString(map);
	}
	
}
