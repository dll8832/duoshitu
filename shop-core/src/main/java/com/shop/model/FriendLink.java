package com.shop.model;


import com.shop.base.BaseModel;

/**
 * Entity - 友情链接
 */
@SuppressWarnings("serial")
public class FriendLink extends BaseModel {


	/** 名称 */
	private String name;

	/** 类型 0=文本 1=图片*/
	private int type;

	/** logo */
	private String logo;

	/** 链接地址 */
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
