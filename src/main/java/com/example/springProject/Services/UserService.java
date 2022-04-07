package com.example.springProject.Services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.springProject.Services.exceptions.DataBaseException;
import com.example.springProject.Services.exceptions.ResourceNotFoundException;
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
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	//Insert new user
	public User insertUser(User obj) {
		return repository.save(obj);
	}
	
	//Delete User
	public void deleteUser(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) { //When deleting user with orders associated
			throw new DataBaseException(e.getMessage());
		}
		
	}
	
	//Update User
	public User updateUser(Long id, User obj) {
		try {
			User entity = repository.getOne(id); //prepares obj, not directly to DB
			updateData(entity,obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
