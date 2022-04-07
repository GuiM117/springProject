package com.example.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springProject.entities.Category;
import com.example.springProject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
