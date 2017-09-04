package com.shop.model;

import com.shop.base.BaseModel;

import java.util.Date;


/**
 * Entity - 购物车
 */
@SuppressWarnings("serial")
public class Cart extends BaseModel {


	public static final int TIMEOUT = 604800;

	/** 密钥 */
	private String cartKey;

	/** 过期时间 */
	private Date expire;

	/** 会员 */
	private Integer member;

	public String getCartKey() {
		return cartKey;
	}

	public void setCartKey(String cartKey) {
		this.cartKey = cartKey;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public Integer getMember() {
		return member;
	}

	public void setMember(Integer member) {
		this.member = member;
	}
}
