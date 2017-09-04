package com.shop.model;


import com.shop.base.BaseModel;

/**
 * Entity - 购物车项
 */
@SuppressWarnings("serial")
public class CartItem extends BaseModel {


	/** 数量 */
	private Integer quantity;

	/** 商品 */
	private Integer product;

	/** 购物车 */
	private Integer cart;
	
	private Product productInfo;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public Integer getCart() {
		return cart;
	}

	public void setCart(Integer cart) {
		this.cart = cart;
	}

	public Product getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(Product productInfo) {
		this.productInfo = productInfo;
	}

}
