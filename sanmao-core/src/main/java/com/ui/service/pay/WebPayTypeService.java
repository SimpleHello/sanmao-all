package com.ui.service.pay;

import java.util.List;

import com.ui.entity.pay.PayDetailEntity;
import com.ui.entity.pay.PayTypeEntity;

public interface WebPayTypeService {

	public List<PayTypeEntity> getPayTypeList(PayTypeEntity entity)  throws Exception;
	
	public boolean insertType(PayTypeEntity entity)  throws Exception;
	
	public boolean updateType(PayTypeEntity entity)  throws Exception;
	
	public boolean DeleteType(PayTypeEntity entity)  throws Exception;
	
	public Integer getIfUsed(PayTypeEntity entity)  throws Exception;
	
	public PayDetailEntity getOnePayType(PayTypeEntity entity)  throws Exception;
}
