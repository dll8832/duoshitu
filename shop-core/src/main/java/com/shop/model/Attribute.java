package com.shop.model;


import com.shop.base.BaseModel;

@SuppressWarnings("serial")
public class Attribute extends BaseModel {
	
	private Integer orders;
	private String name;
	private String options;
	private Integer propertyIndex;
	private Integer productCategory;
	private String[] optionsList;
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public Integer getPropertyIndex() {
		return propertyIndex;
	}
	public void setPropertyIndex(Integer propertyIndex) {
		this.propertyIndex = propertyIndex;
	}
	public String[] getOptionsList() {
		return optionsList;
	}
	public void setOptionsList(String[] optionsList) {
		this.optionsList = optionsList;
	}

	public Integer getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Integer productCategory) {
		this.productCategory = productCategory;
	}
}
