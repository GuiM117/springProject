package com.example.springProject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springProject.entities.User;
import com.example.springProject.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	//Insert new user
	public User insertUser(User obj) {
		return repository.save(obj);
	}
	
	//Delete User
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	//Update User
	public User updateUser(Long id, User obj) {
		User entity = repository.getOne(id); //prepares obj, not directly to DB
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
