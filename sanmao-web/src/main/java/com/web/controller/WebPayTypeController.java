package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ui.base.JSONUtil;
import com.ui.base.JsonResult;
import com.ui.entity.pay.PayDetailEntity;
import com.ui.entity.pay.PayTypeEntity;
import com.ui.service.pay.WebPayTypeService;

@Controller
@RequestMapping("/web/payType")
public class WebPayTypeController {

	@Resource(name = "webPayTypeService")
	WebPayTypeService webPayTypeService;
  
	@RequestMapping("/getList.do")
	public @ResponseBody String getPayTypeList(PayTypeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		List<PayTypeEntity> list = webPayTypeService.getPayTypeList(entity);
		return returnL(list);
	}

	@RequestMapping("/insert.do")
	public @ResponseBody String insertType(PayTypeEntity entity) {
		// TODO Auto-generated method stub
		JsonResult result = new JsonResult();
		try{
			webPayTypeService.updateType(entity);
			result = new JsonResult(1,"新增成功" , null);
		}
		catch(Exception ex){
			result = new JsonResult(-1, ex.getMessage(), null);
		}
		return returnL(result);
	}

	@RequestMapping("/update.do")
	public @ResponseBody String updateType(PayTypeEntity entity) {
		// TODO Auto-generated method stub
		JsonResult result = new JsonResult();
		try{
			webPayTypeService.updateType(entity);
			result = new JsonResult(1,"修改成功" , null);
		}
		catch(Exception ex){
			result = new JsonResult(-1, ex.getMessage(), null);
		}
		return returnL(result);
	}

	@RequestMapping("/delete.do")
	public @ResponseBody String DeleteType(PayTypeEntity entity) {
		// TODO Auto-generated method stub
		JsonResult result = new JsonResult();
		try{
			boolean flag = webPayTypeService.DeleteType(entity);
			String message = "删除成功";
			if(!flag){
				message = "该类型已被调用 不能删除";
			}
			result = new JsonResult(1,message , null);
		}
		catch(Exception ex){
			result = new JsonResult(-1, ex.getMessage(), null);
		}
		return returnL(result);
	}

	@RequestMapping("/getIfUsed.do")
	public @ResponseBody String getIfUsed(PayTypeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		Integer count = webPayTypeService.getIfUsed(entity);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("count", count);
		return returnL(map);
	}

	@RequestMapping("/getOne.do")
	public @ResponseBody String getOnePayType(PayTypeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		PayDetailEntity param = webPayTypeService.getOnePayType(entity);
		return returnL(param);
	}
	
	private String returnL(Object obj){
		String json =JSONUtil.toJsonString(obj);
		return json;
	}
}
