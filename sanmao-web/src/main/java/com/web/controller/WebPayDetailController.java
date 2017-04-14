package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ui.base.JSONUtil;
import com.ui.base.JsonResult;
import com.ui.base.PagedJsonResult;
import com.ui.entity.pay.PayDetailEntity;
import com.ui.service.pay.WebPayDetailService;

@Controller
@RequestMapping("/web/payDetail")
public class WebPayDetailController {
	
	@Resource(name="webPayDetailService")
	private WebPayDetailService webPayDetailService;
	
	@RequestMapping("/getList.do")
	public @ResponseBody String getPayDetailList(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		if(entity.getPage()==null){
			entity.setPage(1);
		}
		if(entity.getLimit()==null){
			entity.setLimit(10);
		}
		entity.setOffset((entity.getPage()-1)*entity.getLimit());
		List<PayDetailEntity> list = webPayDetailService.getPayDetailList(entity);
		Integer count = webPayDetailService.getCount(entity);
		PagedJsonResult result = new PagedJsonResult(list, 1, null, count, entity.getLimit());
		return returnL(result);
	}

	@RequestMapping(value = "/insert.do")
	public @ResponseBody String insertDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		JsonResult result = new JsonResult();		
		try{
			webPayDetailService.insertDetail(entity);
			result = new JsonResult(1, "新增成功", null);
		}
		catch(Exception ex){
			result = new JsonResult(-1, ex.getMessage(), null);
		}
		return returnL(result);
	}

	@RequestMapping("/update.do")
	public @ResponseBody String updateDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		JsonResult result = new JsonResult();
		try{
			webPayDetailService.updateDetail(entity);
			result = new JsonResult(1, "修改成功", null);
		}
		catch(Exception ex){
			result = new JsonResult(-1, ex.getMessage(), null);
		}
		return returnL(result);
	}

	@RequestMapping("/delete.do")
	public @ResponseBody String deleteDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		JsonResult result = new JsonResult();
		try{
			webPayDetailService.deleteDetail(entity);
			result = new JsonResult(1, "删除成功", null);
		}
		catch(Exception ex){
			result = new JsonResult(-1, ex.getMessage(), null);
		}
		return returnL(result);
	}

	@RequestMapping("/getOne.do")
	public @ResponseBody String getOnePayDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		PayDetailEntity enti = webPayDetailService.getOnePayDetail(entity);
		return returnL(enti);
	}
	
	public String returnL(Object obj){
		String json =JSONUtil.toJsonString(obj);
		return json;
	}
}
