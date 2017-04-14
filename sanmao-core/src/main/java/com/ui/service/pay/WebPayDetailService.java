package com.ui.service.pay;

import java.util.List;

import com.ui.entity.pay.PayDetailEntity;

/**
 * 支出明细 操作
 * @author Administrator
 *
 */
public interface WebPayDetailService {
	
	public List<PayDetailEntity> getPayDetailList(PayDetailEntity entity) throws Exception;
	
	public Integer getCount(PayDetailEntity entity) throws Exception;
	
	public boolean insertDetail(PayDetailEntity entity) throws Exception;
	
	public boolean updateDetail(PayDetailEntity entity) throws Exception;
	
	public boolean deleteDetail(PayDetailEntity entity) throws Exception;
	
	public PayDetailEntity getOnePayDetail(PayDetailEntity entity) throws Exception;
}
