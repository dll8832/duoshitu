package com.shop.model;

import com.shop.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Entity - 订单
 * 
 */
@SuppressWarnings("serial")
public class Order extends BaseModel {


	/** 锁定过期时间 */
	public static final int LOCK_EXPIRE = 60;

	/** 编号 */
	private String sn;

	/** 类型 */
	private int type;

	/** 状态 */
	private int status;

	/** 商品价格 */
	private BigDecimal price;

	/** 支付手续费 */
	private BigDecimal fee;

	/** 运费 */
	private BigDecimal freight;

	/** 税金 */
	private BigDecimal tax;

	/** 促销折扣 */
	private BigDecimal promotionDiscount;

	/** 优惠券折扣 */
	private BigDecimal couponDiscount;

	/** 调整金额 */
	private BigDecimal offsetAmount;

	/** 订单金额 */
	private BigDecimal amount;

	/** 已付金额 */
	private BigDecimal amountPaid;

	/** 退款金额 */
	private BigDecimal refundAmount;

	/** 赠送积分 */
	private Long rewardPoint;

	/** 兑换积分 */
	private Long exchangePoint;

	/** 商品重量 */
	private Integer weight;

	/** 商品数量 */
	private Integer quantity;

	/** 已发货数量 */
	private Integer shippedQuantity;

	/** 已退货数量 */
	private Integer returnedQuantity;

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

	/** 附言 */
	private String memo;

	/** 过期时间 */
	private Date expire;

	/** 是否已使用优惠码 */
	private Boolean isUseCouponCode;

	/** 是否已兑换积分 */
	private Boolean isExchangePoint;

	/** 是否已分配库存 */
	private Boolean isAllocatedStock;

	/** 支付方式名称 */
	private String paymentMethodName;
	
	private Integer shippingMethod;

	/** 配送方式名称 */
	private String shippingMethodName;

	/** 锁定KEY */
	private String lockKey;

	/** 锁定过期时间 */
	private Date lockExpire;

	/** 完成日期 */
	private Date completeDate;

	/** 地区 */
	private Integer area;

	/** 会员 */
	private Integer member;
	
	/** 发票内容 */
	private String invoiceContent; 
	private String invoiceTitle;
	private Integer paymentMethodType;
	private Integer paymentMethod;
	private String promotionNames;
	private String couponCode;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getPromotionDiscount() {
		return promotionDiscount;
	}

	public void setPromotionDiscount(BigDecimal promotionDiscount) {
		this.promotionDiscount = promotionDiscount;
	}

	public BigDecimal getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(BigDecimal couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public BigDecimal getOffsetAmount() {
		return offsetAmount;
	}

	public void setOffsetAmount(BigDecimal offsetAmount) {
		this.offsetAmount = offsetAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getShippedQuantity() {
		return shippedQuantity;
	}

	public void setShippedQuantity(Integer shippedQuantity) {
		this.shippedQuantity = shippedQuantity;
	}

	public Integer getReturnedQuantity() {
		return returnedQuantity;
	}

	public void setReturnedQuantity(Integer returnedQuantity) {
		this.returnedQuantity = returnedQuantity;
	}

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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public Boolean getIsUseCouponCode() {
		return isUseCouponCode;
	}

	public void setIsUseCouponCode(Boolean isUseCouponCode) {
		this.isUseCouponCode = isUseCouponCode;
	}

	public Boolean getIsExchangePoint() {
		return isExchangePoint;
	}

	public void setIsExchangePoint(Boolean isExchangePoint) {
		this.isExchangePoint = isExchangePoint;
	}

	public Boolean getIsAllocatedStock() {
		return isAllocatedStock;
	}

	public void setIsAllocatedStock(Boolean isAllocatedStock) {
		this.isAllocatedStock = isAllocatedStock;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public String getShippingMethodName() {
		return shippingMethodName;
	}

	public void setShippingMethodName(String shippingMethodName) {
		this.shippingMethodName = shippingMethodName;
	}

	public String getLockKey() {
		return lockKey;
	}

	public void setLockKey(String lockKey) {
		this.lockKey = lockKey;
	}

	public Date getLockExpire() {
		return lockExpire;
	}

	public void setLockExpire(Date lockExpire) {
		this.lockExpire = lockExpire;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
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

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public Integer getPaymentMethodType() {
		return paymentMethodType;
	}

	public Integer getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(Integer shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPromotionNames() {
		return promotionNames;
	}

	public void setPromotionNames(String promotionNames) {
		this.promotionNames = promotionNames;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public void setPaymentMethodType(Integer paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}
}
