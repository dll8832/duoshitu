package com.shop.model;

import com.shop.base.BaseModel;

@SuppressWarnings("serial")
public class Brand extends BaseModel {
	
	private Integer orders;
	private String introduction; // 介绍
	private String logo; // logo
	private String name; // 品牌名称
	private Integer type; // 0=文本 1=图片
	private String url; // 网址
	
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
