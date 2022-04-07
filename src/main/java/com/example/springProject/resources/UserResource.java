package com.example.springProject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springProject.Services.UserService;
import com.example.springProject.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Rest for Adding new User
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User obj){ // Deserialize JSOn -> requestBody
		obj = service.insertUser(obj);
		//Creating path for added obj into URI (created accepts only URI) to get http 201 -> resource created
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	//Rest for deleting User
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		service.deleteUser(id);
		return ResponseEntity.noContent().build();	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User obj ){
		obj = service.updateUser(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	/*  Postman Test
	 *  {
			"name": "Bob Brown",
			"email": "bob@gmail.com",
			"phone": "977557755",
			"password": "123456"
		}
	 */
}
