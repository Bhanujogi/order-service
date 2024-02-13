package com.springboot.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

//OrderService.java

import org.springframework.stereotype.Service;

import com.springboot.Repository.OrderRepository;
import com.springboot.Repository.OrderResponse;
import com.springboot.model.Constants;
import com.springboot.model.Order;
import com.springboot.model.OrderRequest;
import com.springboot.response.DataNotFoundException;

import jakarta.validation.Valid;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRespository;

	@Override
	public void createOrder(OrderRequest orderRequest) {

		Order order = convertOrderRequestToOrder(orderRequest);
		orderRespository.save(order);

	}

	private static Order convertOrderRequestToOrder(OrderRequest orderRequest) {

		Order order = new Order();
		order.setAmount(orderRequest.getAmount());
		order.setOrderName(orderRequest.getOrderName());

		return order;
	}

	@Override
	public OrderResponse getOrderById(Long id) {

		// Retrieve order from the database by ID and convert it to OrderResponse

		Order order = orderRespository.findById(id).orElse(null);
		if (order != null) {
			return new OrderResponse(order.getOrderId(), order.getOrderName(), order.getAmount());
		} else {

			throw new DataNotFoundException(Constants.ORDER_NOT_FOUND);
		}
	}

	@Override
	public boolean updateOrder(Long id, @Valid OrderRequest updatedOrderRequest) {
		// Retrieve Order from the database by ID

		Optional<Order> order = orderRespository.findById(id);
		if (order.isPresent()) {

			Order _order = order.get();
			_order.setOrderName(updatedOrderRequest.getOrderName());
			_order.setAmount(updatedOrderRequest.getAmount());

			orderRespository.save(_order);
			return true;
		} else {

			throw new DataNotFoundException(Constants.ORDER_NOT_FOUND);
		}
	}

	@Override
	public boolean deleteOrderById(Long id) {

		OrderResponse order = getOrderById(id);

		if (order != null) {

			orderRespository.deleteById(id);
			return true;
		}

		throw new DataNotFoundException(Constants.ORDER_NOT_FOUND);
	}
}
