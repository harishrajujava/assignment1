package com.myshop.att.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String planId;
	@OneToOne
	private HardSKU skuId;
	private int quantity;
	private String telephoneNumber;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private boolean complete;
	@OneToOne
	private DateRange estimatedShipDateRange;
	@OneToOne
	private DateRange newEstimatedShipDateRange;
	private boolean userAcceptedDelay;
	private Timestamp delayAcceptedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public HardSKU getSkuId() {
		return skuId;
	}
	public void setSkuId(HardSKU skuId) {
		this.skuId = skuId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public DateRange getEstimatedShipDateRange() {
		return estimatedShipDateRange;
	}
	public void setEstimatedShipDateRange(DateRange estimatedShipDateRange) {
		this.estimatedShipDateRange = estimatedShipDateRange;
	}
	public DateRange getNewEstimatedShipDateRange() {
		return newEstimatedShipDateRange;
	}
	public void setNewEstimatedShipDateRange(DateRange newEstimatedShipDateRange) {
		this.newEstimatedShipDateRange = newEstimatedShipDateRange;
	}
	public boolean isUserAcceptedDelay() {
		return userAcceptedDelay;
	}
	public void setUserAcceptedDelay(boolean userAcceptedDelay) {
		this.userAcceptedDelay = userAcceptedDelay;
	}
	public Timestamp getDelayAcceptedDate() {
		return delayAcceptedDate;
	}
	public void setDelayAcceptedDate(Timestamp delayAcceptedDate) {
		this.delayAcceptedDate = delayAcceptedDate;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
