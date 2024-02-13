package com.springboot.controller;

//OrderController.java

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Repository.ApiResponse;
import com.springboot.Repository.OrderResponse;
import com.springboot.Service.OrderService;
import com.springboot.model.OrderRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/order-service")
@Validated
@Tag(name = "OrderController", description = "To perform operations on order")
public class OrderController {

	private final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@Operation(summary = "Post operations on order", description = "Used to save order object in database")
	@PostMapping("/post")
	public ResponseEntity<ApiResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {

		orderService.createOrder(orderRequest);
		logger.info("Order created successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Order created successfully"));
	}

	@Operation(summary = "Get order details by ID", description = "Retrieve order details by order ID")
	@GetMapping("/get/{id}")
	public ResponseEntity<OrderResponse> getOrderById(@Valid @PathVariable("id") Long id) {

		OrderResponse orderResponse = orderService.getOrderById(id);

		if (orderResponse != null) {
			return ResponseEntity.ok(orderResponse);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Operation(summary = "Update order details by ID", description = "Used to update order details by order ID")
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateOrder(@Valid @PathVariable("id") Long id, @RequestBody OrderRequest orderRequest) {

		boolean update = orderService.updateOrder(id, orderRequest);
		if (update) {

			return ResponseEntity.ok(new ApiResponse(true, "Order updated successfully"));
		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(false, "Order not found or update failed"));
		}
	}

	@Operation(summary = "Delete order details by ID", description = "Used to delete order details by order ID")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteOrderById(@PathVariable("id") Long id) {
		boolean deleteStatus = orderService.deleteOrderById(id);

		if (deleteStatus) {
			logger.info("Order deleted successfully");
			return ResponseEntity.ok(new ApiResponse(true, "Order deleted successfully"));
		} else {
			logger.info("Order not found or delete failed");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(false, "Order not found or delete failed"));
		}

	}

	/*
	 * @Operation( summary = "Update operations on order", description =
	 * "Used to update order details by order ID" )
	 * 
	 * @PutMapping("/order/{Id}") public ResponseEntity<ApiResponse> updateOrder(
	 * 
	 * @PathVariable Long Id,
	 * 
	 * @Valid @RequestBody OrderRequest updatedOrderRequest) {
	 * 
	 * boolean updated = orderService.updateOrder(Id, updatedOrderRequest);
	 * 
	 * if (updated) { logger.info("Order updated successfully"); return
	 * ResponseEntity.ok(new ApiResponse(true, "Order updated successfully")); }
	 * else { logger.info("Order not found or update failed"); return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND) .body(new ApiResponse(false,
	 * "Order not found or update failed")); } }
	 */
}

/*
 * keypoints Used @Validated and @Valid annotations for validation. Utilized
 * validation annotations in OrderRequest for cleaner and more expressive
 * validation. Moved the validation logic from the controller to the
 * OrderRequest class. Used the ApiResponse class for consistent and structured
 * responses.
 */
