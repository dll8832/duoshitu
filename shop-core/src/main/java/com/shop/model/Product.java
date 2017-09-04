package com.shop.model;

import com.alibaba.fastjson.JSON;
import com.shop.base.BaseModel;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品表
 */
@SuppressWarnings("serial")
public class Product extends BaseModel {
	/** 编号 */
	private String sn;

	/** 销售价 */
	private BigDecimal price;

	/** 成本价 */
	private BigDecimal cost;

	/** 市场价 */
	private BigDecimal marketPrice;

	/** 赠送积分 */
	private Long rewardPoint;

	/** 兑换积分 */
	private Long exchangePoint;

	/** 库存 */
	private Integer stock;

	/** 消耗的库存 */
	private Integer allocatedStock;

	/** 是否默认 */
	private Boolean isDefault;
	/** 货品ID */
	private Integer goods;

	/** 规格值 [{"id":2,"value":"银色"},{"id":6,"value":"16GB"}]*/
	private String specificationValues;
	
	private List<SpecificationValue> specificationValueList;
	
	private String name;
	private String thumbnail;
	
	private Integer weight; // 商品重量
	
	private Integer type; // 商品类别
	
	private Boolean isDelivery; // 是否需要配送
	
	
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Long getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(Long rewardPoint) {
		this.rewardPoint = rewardPoint;
	}

	public Long getExchangePoint() {
		return exchangePoint;
	}

	public void setExchangePoint(Long exchangePoint) {
		this.exchangePoint = exchangePoint;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getAllocatedStock() {
		return allocatedStock;
	}

	public void setAllocatedStock(Integer allocatedStock) {
		this.allocatedStock = allocatedStock;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getGoods() {
		return goods;
	}

	public void setGoods(Integer goods) {
		this.goods = goods;
	}

	public String getSpecificationValues() {
		return specificationValues;
	}

	public void setSpecificationValues(String specificationValues) {
		this.specificationValues = specificationValues;
		if (this.specificationValues != null && this.specificationValues.trim().length() > 1) {
			this.specificationValueList = JSON.parseArray(this.specificationValues, SpecificationValue.class);
		}
		
	}

	public List<SpecificationValue> getSpecificationValueList() {
		return specificationValueList;
	}

	public void setSpecificationValueList(List<SpecificationValue> specificationValueList) {
		this.specificationValueList = specificationValueList;
	}
	
	/**
	 * 获取规格值ID
	 * @return 规格值ID
	 */
	public List<Integer> getSpecificationValueIds() {
		List<Integer> specificationValueIds = new ArrayList<Integer>();
		if (CollectionUtils.isNotEmpty(getSpecificationValueList())) {
			for (SpecificationValue specificationValue : getSpecificationValueList()) {
				specificationValueIds.add(specificationValue.getId());
			}
		}/** 规格值 [{"id":2,"value":"银色"},{"id":6,"value":"16GB"}]*/
		return specificationValueIds;//[2,6]
	}

	/**
	 * 获取规格
	 * @return 规格
	 */
	public List<String> getSpecifications() {
		List<String> specifications = new ArrayList<String>();
		if (CollectionUtils.isNotEmpty(getSpecificationValueList())) {
			for (SpecificationValue specificationValue : getSpecificationValueList()) {
				specifications.add(specificationValue.getValue());
			}
		}
		return specifications; //["银色", "16GB"]
	}
	
	/**
	 * 获取剩余库存
	 * @return 剩余库存
	 */
	public Integer getAvailableStock() {
		if (this.stock == null) {
			this.stock = 0;
		}
		if (this.allocatedStock == null) {
			this.allocatedStock = 0;
		}
		return this.stock - this.allocatedStock;
	}

	public String getName() {
		return name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getType() {
		return type;
	}

	public Boolean getIsDelivery() {
		return isDelivery;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setIsDelivery(Boolean isDelivery) {
		this.isDelivery = isDelivery;
	}
	
}
