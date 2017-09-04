package com.shop.model;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SpecificationItem implements Serializable {

	private static final long serialVersionUID = 7439600600538635747L;

	/** 名称 */
    private String name;

	/** 条目 */
	private List<SpecificationItemEntry> entries = new ArrayList<SpecificationItemEntry>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SpecificationItemEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<SpecificationItemEntry> entries) {
		this.entries = entries;
	}
	
	/**
	 * 判断是否已选
	 * 
	 * @return 是否已选
	 */
	public boolean isSelected() {
		if (CollectionUtils.isNotEmpty(getEntries())) {
			for (SpecificationItemEntry entry : getEntries()) {
				if (entry.getIsSelected()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断规格值是否有效
	 * @param specificationValue
	 *            规格值
	 * @return 规格值是否有效
	 */
	public boolean isValid(SpecificationValue specificationValue) {
		if (specificationValue != null && specificationValue.getId() != null && StringUtils.isNotEmpty(specificationValue.getValue()) && CollectionUtils.isNotEmpty(getEntries())) {
			for (SpecificationItemEntry entry : getEntries()) {
				if (entry != null && entry.getIsSelected() && specificationValue.getId().equals(entry.getId()) && StringUtils.equals(entry.getValue(), specificationValue.getValue())) {
					return true;
				}
			}
		}
		return false;
	}
}
