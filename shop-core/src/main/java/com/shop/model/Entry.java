package com.shop.model;

import java.io.Serializable;

/**
 * Entity - 条目
 */
public class Entry implements Serializable {

	private static final long serialVersionUID = 2507799432135866022L;

    /** 名称 */
	private String name;
	/** 值 */
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
