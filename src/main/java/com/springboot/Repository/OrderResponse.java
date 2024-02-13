package com.springboot.Repository;

import com.springboot.model.Order;

import lombok.Data;

//OrderResponse.java
@Data
public class OrderResponse {

	private Long orderId;
	private String orderName;
	private Double amount;

	// Constructors, getters and setters

	public OrderResponse(Long orderId, String orderName, Double amount) {
		this.orderId = orderId;
		this.orderName = orderName;
		this.amount = amount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	
	/*
	 * public OrderResponse(Order order) { this.orderId = order.getOrderId();
	 * this.orderName = order.getOrderName(); this.amount = order.getAmount(); }
	 */

	/*
	 * public OrderResponse(Order order) { }
	 * 
	 * public Long getOrderId() { return orderId; }
	 * 
	 * public void setOrderId(Long orderId) { this.orderId = orderId; }
	 * 
	 * public String getOrderName() { return orderName; }
	 * 
	 * public void setOrderName(String orderName) { this.orderName = orderName; }
	 * 
	 * public Double getAmount() { return amount; }
	 * 
	 * public void setAmount(Double amount) { this.amount = amount; }
	 */

}
