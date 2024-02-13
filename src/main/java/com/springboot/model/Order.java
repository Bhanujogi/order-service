package com.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long orderId;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "order_name")
	private String orderName;


	public Order() {
		super();
	}

	public Order(long orderId, Double amount, String orderName) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.orderName = orderName;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", orderName=" + orderName + "]";
	}

	/*
	 * public void updateFromRequest(@Valid OrderRequest updatedOrderRequest) { //
	 * Update fields based on the OrderRequest this.orderName =
	 * updatedOrderRequest.getOrderName(); this.amount =
	 * updatedOrderRequest.getAmount(); }
	 */

}
