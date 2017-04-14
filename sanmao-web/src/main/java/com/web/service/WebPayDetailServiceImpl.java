package com.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ui.base.DaoHelper;
import com.ui.entity.pay.PayDetailEntity;
import com.ui.service.pay.WebPayDetailService;

@Service("webPayDetailService")
public class WebPayDetailServiceImpl implements WebPayDetailService {
	public static final String namespace = "web_pay_detail";
	
	@Resource(name = "writeDaoHelper")
    DaoHelper writeDao;
    @Resource(name = "readDaoHelper")
    DaoHelper readDao;
	@Override
	public List<PayDetailEntity> getPayDetailList(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return readDao.query(namespace, "getPayDetailList", entity);
	}

	@Override
	public Integer getCount(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return readDao.count(namespace, "getCount", entity);
	}

	@Override
	public boolean insertDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		try{
			writeDao.insert(namespace, "insertDetail", entity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		try{
			writeDao.insert(namespace, "updateDetail", entity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		try{
			writeDao.insert(namespace, "deleteDetail", entity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public PayDetailEntity getOnePayDetail(PayDetailEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return readDao.getOne(namespace, "getCount", entity);
	}

}
