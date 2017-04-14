package com.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ui.base.DaoHelper;
import com.ui.entity.pay.PayDetailEntity;
import com.ui.entity.pay.PayTypeEntity;
import com.ui.service.pay.WebPayTypeService;

@Service("webPayTypeService")
public class WebPayTypeServiceImpl implements WebPayTypeService {
	public static final String namespace = "web_pay_type_config";
	
	@Resource(name = "writeDaoHelper")
    DaoHelper writeDao;
    @Resource(name = "readDaoHelper")
    DaoHelper readDao;
	@Override
	public List<PayTypeEntity> getPayTypeList(PayTypeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return readDao.query(namespace,"getPayTypeList", entity);
	}

	@Override
	public boolean insertType(PayTypeEntity entity) {
		// TODO Auto-generated method stub
		try{
			writeDao.insert(namespace, "insertType", entity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateType(PayTypeEntity entity) {
		// TODO Auto-generated method stub
		try{
			writeDao.update(namespace, "updateType", entity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean DeleteType(PayTypeEntity entity) {
		// TODO Auto-generated method stub
		try{
			Integer  i = getIfUsed(entity);
			if(i>0){
				return false;
			}
			writeDao.delete(namespace, "DeleteType", entity);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Integer getIfUsed(PayTypeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return readDao.count(namespace,"getIfUsed", entity);
	}

	@Override
	public PayDetailEntity getOnePayType(PayTypeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return readDao.getOne(namespace,"getOnePayType", entity);
	}

}
