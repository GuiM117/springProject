package com.example.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springProject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
