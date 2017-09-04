package com.shop.model;

import com.shop.base.BaseModel;

import java.util.List;


/**
 * Entity - 广告位
 */
@SuppressWarnings("serial")
public class AdPosition extends BaseModel {

	/** 名称 */
	private String name;

	/** 宽度 */
	private Integer width;

	/** 高度 */
	private Integer height;

	/** 描述 */
	private String description;

	/** 模板 */
	private String template;
	
	/** 广告 */
	private List<Ad> ads;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

}
