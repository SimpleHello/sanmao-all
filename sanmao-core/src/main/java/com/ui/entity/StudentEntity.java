package com.ui.entity;

import com.ui.base.IEntity;
/**
 * 测试  学生类
 * @author Administrator
 *
 */
public class StudentEntity extends IEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -15074796668840061L;
	
	private int id;
	private String name;
//	private int classId;
//	private String className;
	private int age;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
