package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
