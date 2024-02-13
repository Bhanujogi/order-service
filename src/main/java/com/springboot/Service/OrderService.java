package com.springboot.Service;

import com.springboot.Repository.OrderResponse;
import com.springboot.model.OrderRequest;

public interface OrderService {

	public void createOrder(OrderRequest orderRequest);

	public OrderResponse getOrderById(Long Id);

	public boolean updateOrder(Long Id, OrderRequest orderRequest);

	public boolean deleteOrderById(Long id);

}
