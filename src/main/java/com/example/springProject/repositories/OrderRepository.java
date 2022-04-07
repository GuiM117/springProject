package com.example.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springProject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}