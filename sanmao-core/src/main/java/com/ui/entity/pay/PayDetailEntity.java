package com.ui.entity.pay;

import java.util.Date;

import com.ui.base.IEntity;

public class PayDetailEntity  extends IEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4052661080527269248L;

	private Integer id;//主键ID
	
	private Integer typeId;//
	private String typeName;//
	private Integer typeFaId;//
	private String typeFaName;//
	private String bake;
	private Double payNum;
	private String payDate;
	// 查询参数
	
	private String startDate;
	private String endDate;
	private int payMin;
	private int payMax;
	//分页
	private transient Integer limit;
	private transient Integer page;
	private transient Integer offset;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getTypeFaId() {
		return typeFaId;
	}
	public void setTypeFaId(Integer typeFaId) {
		this.typeFaId = typeFaId;
	}
	public String getTypeFaName() {
		return typeFaName;
	}
	public void setTypeFaName(String typeFaName) {
		this.typeFaName = typeFaName;
	}
	public String getBake() {
		return bake;
	}
	public void setBake(String bake) {
		this.bake = bake;
	}
	public Double getPayNum() {
		return payNum;
	}
	public void setPayNum(Double payNum) {
		this.payNum = payNum;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPayMin() {
		return payMin;
	}
	public void setPayMin(int payMin) {
		this.payMin = payMin;
	}
	public int getPayMax() {
		return payMax;
	}
	public void setPayMax(int payMax) {
		this.payMax = payMax;
	}
	
	
}
