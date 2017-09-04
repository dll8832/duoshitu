package com.shop.model;

import com.shop.base.BaseModel;
import com.shop.constant.TypeEnum;

import java.beans.Transient;
import java.util.Date;

@SuppressWarnings("serial")
public class Ad extends BaseModel {
	
	private Integer orders;
	/** 标题 */
	private String title;

	/** 类型 0=文本 1=图片*/
	private TypeEnum type;

	/** 内容 */
	private String content;

	/** 路径 */
	private String path;

	/** 起始日期 */
	private Date beginDate;

	/** 结束日期 */
	private Date endDate;

	/** 链接地址 */
	private String url;
	
	private Integer adPosition;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getAdPosition() {
		return adPosition;
	}

	public void setAdPosition(Integer adPosition) {
		this.adPosition = adPosition;
	}
	
	/**
	 * 判断是否已开始
	 * 
	 * @return 是否已开始
	 */
	public boolean hasBegun() {
		//return getBeginDate() == null || new Date().getTime() - getBeginDate().getTime() >= 0 ;
		return getBeginDate() == null || !getBeginDate().after(new Date());
	}

	/**
	 * 判断是否已结束
	 * 
	 * @return 是否已结束
	 */
	public boolean hasEnded() {
		//return getEndDate() != null && getEndDate().getTime() - new Date().getTime() <=0;
		return getEndDate() != null && !getEndDate().after(new Date());
	}
}