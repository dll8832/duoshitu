package com.shop.constant;

/**
 * 类型
 */
public enum TypeEnum {

	/** 文本 */
	text("text", 0),

	/** 图片 */
	image("image", 1);

	private int type;
	private String name;

	private TypeEnum() {

	}
	private TypeEnum(String name, int type) {
		this.name = name;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
