package com.springboot.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.Service.OrderService;
import com.springboot.Service.OrderServiceImpl;
import com.springboot.model.OrderRequest;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

	// to tell that copy perticular class and then test
	@InjectMocks
	private OrderController orderController;

	@Mock
	private OrderServiceImpl orderServiceImpl;


	@Test
	void testCreateOrder() {
		OrderRequest orderRequest = new OrderRequest();
		Mockito.doNothing().when(orderServiceImpl).createOrder(orderRequest);

		orderController.createOrder(orderRequest);
		verify(orderServiceImpl, times(1)).createOrder(orderRequest);
	}

//
//	@Test
//	void testCreateOrder(){
//		
//		OrderRequest orderRequest = new OrderRequest();
//		orderRequest.setAmount(10.2);
//		orderRequest.setOrderName("shirt");
//		Mockito.doNothing().when(orderServiceImpl).createOrder(orderRequest);
//		
//		orderController.createOrder(orderRequest);
//		
//		verify(orderServiceImpl, times(1)).createOrder(any(OrderRequest.class));
//		
//	}

}
