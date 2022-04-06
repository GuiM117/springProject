package com.example.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springProject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
