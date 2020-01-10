package com.derrick.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.derrick.demo.models.User;
import com.derrick.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Object> createUser(@RequestBody User newUser) {
		
		return ResponseEntity.ok(this.userService.createUser(newUser));
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> getUser(@PathVariable("id") int userId) {
		
		return ResponseEntity.ok(this.userService.getUser(userId));
	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> updateUser(@PathVariable("id") int userId, @RequestBody User user) {
		
		return ResponseEntity.ok(this.userService.updateUser(userId, user));
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int userId) {
		
		return ResponseEntity.ok(this.userService.deleteUser(userId));
	}

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<Object> listUsers(@RequestParam(value="page", defaultValue="1") int page) {
		
		return ResponseEntity.ok(this.userService.listUsers(page));
	}
}
