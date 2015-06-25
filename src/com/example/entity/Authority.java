package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Authority extends SuperEntity {

	private static final long serialVersionUID = -183647072937679415L;
	
	/**
	 * 权限名称. 
	 * 供SpringSecurity使用的权限的名称. 例如: ROLE_USER_UPDATE
	 */
	@Column(name="name", length=30)
	private String name;
	
	
	/**
	 * 权限显示名,用于权限管理时使用
	 */
	@Column(name="display_name", length=30)
	private String displayName;
	
	
	/**
	 * 该权限所能访问的url地址
	 */
	@Column(name="url", length=100)
	private String url;


	public Authority() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Authority [name=" + name + ", displayName=" + displayName
				+ ", url=" + url + "]";
	}
	
}
