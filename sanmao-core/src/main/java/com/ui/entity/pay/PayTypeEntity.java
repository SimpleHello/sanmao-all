package com.ui.entity.pay;

import com.ui.base.IEntity;

/**
 * 支出类别
 * @author Administrator
 *
 */
public class PayTypeEntity  extends IEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7700047749797273831L;
	
	private Integer id;
	private String  name;
	private Integer faId;
	private String faName;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFaId() {
		return faId;
	}
	public void setFaId(Integer faId) {
		this.faId = faId;
	}
	public String getFaName() {
		return faName;
	}
	public void setFaName(String faName) {
		this.faName = faName;
	}
	
	
}
