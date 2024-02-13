package com.springboot.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

//OrderRequest.java
@Data
public class OrderRequest {

 @NotNull(message = Constants.NULL_VALUE)
 @Min(value = 1, message = Constants.MIN_VALUE)
 private Double amount;

 @NotBlank(message = "orderName is required")
 @Pattern(regexp = Constants.ORDER_NAME_REGEX_PATTERN, message = Constants.ORDER_NAME_SIZE)
 private String orderName;

 
 
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

 // Getters and setters
 
}
