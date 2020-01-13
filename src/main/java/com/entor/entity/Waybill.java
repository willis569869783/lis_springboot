package com.entor.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
public class Waybill implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 运单号
	 */
	@TableId(type = IdType.ASSIGN_UUID)
	private String waybillNo;

	/**
	 * 发件人姓名
	 */
	private String wName;

	/**
	 * 发件人手机
	 */
	private String wPhone;

	/**
	 * 发货人地址
	 */
	private String wAddress;

	/**
	 * 收件的姓名
	 */
	private String rName;

	/**
	 * 收件人手机
	 */
	private String rPhone;

	/**
	 * 收件的地址
	 */
	private String rAddress;

	/**
	 * 1审核通过、0审核未通过、-1异常
	 */
	@TableField("Order_state")
	private Integer orderState;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getwPhone() {
		return wPhone;
	}

	public void setwPhone(String wPhone) {
		this.wPhone = wPhone;
	}

	public String getwAddress() {
		return wAddress;
	}

	public void setwAddress(String wAddress) {
		this.wAddress = wAddress;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrPhone() {
		return rPhone;
	}

	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}

	public String getrAddress() {
		return rAddress;
	}

	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Waybill{" + "waybillNo=" + waybillNo + ", wName=" + wName + ", wPhone=" + wPhone + ", wAddress="
				+ wAddress + ", rName=" + rName + ", rPhone=" + rPhone + ", rAddress=" + rAddress + ", orderState="
				+ orderState + ", createTime=" + createTime + "}";
	}
}
