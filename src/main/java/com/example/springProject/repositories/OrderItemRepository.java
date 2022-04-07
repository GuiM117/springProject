package com.example.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springProject.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
