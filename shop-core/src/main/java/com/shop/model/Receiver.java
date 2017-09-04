package com.shop.model;


import com.shop.base.BaseModel;

/**
 * Entity - 收货地址
 */
@SuppressWarnings("serial")
public class Receiver extends BaseModel {
	
	/** 收货地址最大保存数 */
	public static final Integer MAX_RECEIVER_COUNT = 10;

	/** 收货人 */
	private String consignee;

	/** 地区名称 */
	private String areaName;

	/** 地址 */
	private String address;

	/** 邮编 */
	private String zipCode;

	/** 电话 */
	private String phone;

	/** 是否默认 1=默认 0=不是*/
	private Boolean isDefault;

	/** 地区 */
	private Integer area;

	/** 会员 */
	private Integer member;

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getMember() {
		return member;
	}

	public void setMember(Integer member) {
		this.member = member;
	}
}
