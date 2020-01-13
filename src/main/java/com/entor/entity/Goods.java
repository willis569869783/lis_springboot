package com.entor.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 货物id
	 */
	@TableId(type = IdType.ASSIGN_UUID)
	private String goodsId;

	/**
	 * 货物名字
	 */
	private String goodsName;

	/**
	 * 货物信息
	 */
	private String goodsInformation;

	/**
	 * 货物重量
	 */
	private String goodsWeight;

	/**
	 * 货物收件人
	 */
	private String goodsAddressee;

	/**
	 * 订单id
	 */
	private String orderId;

	/**
	 * 发送人id（用户id）
	 */
	private String senderId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsInformation() {
		return goodsInformation;
	}

	public void setGoodsInformation(String goodsInformation) {
		this.goodsInformation = goodsInformation;
	}

	public String getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public String getGoodsAddressee() {
		return goodsAddressee;
	}

	public void setGoodsAddressee(String goodsAddressee) {
		this.goodsAddressee = goodsAddressee;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Goods{" + "goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsInformation=" + goodsInformation
				+ ", goodsWeight=" + goodsWeight + ", goodsAddressee=" + goodsAddressee + ", orderId=" + orderId
				+ ", senderId=" + senderId + ", createTime=" + createTime + "}";
	}
}
