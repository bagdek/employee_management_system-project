package com.projectEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectEMS.dto.UserDTO;
import com.projectEMS.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	  @GetMapping("/get/{id}") 
	  public ResponseEntity<UserDTO> getUserById(@PathVariable int id) { 
      UserDTO userDTO = userService.getUserById(id); 
      return ResponseEntity.ok(userDTO); 
	  }
	  
	  @GetMapping("/get/all")
	    public List<UserDTO> getAllUsers() {
	        List<UserDTO> userDTOs = userService.getAllUsers();
	        return userDTOs;
	  }
	  
	  @PostMapping("/createUsers") 
	  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) { 
      UserDTO createdUser = userService.createUser(userDTO); 
      return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	  }
	  
	  @PutMapping("/update/{id}") 
	  public ResponseEntity<UserDTO> updateUser(@PathVariable int id,@RequestBody UserDTO userDTO) { 
	  UserDTO updatedUser = userService.updateUser(id, userDTO); 
	  return ResponseEntity.ok(updatedUser);
	  }
	  
	  @DeleteMapping("/delete/{id}") 
	  public ResponseEntity<Void> deleteUser(@PathVariable int id) { 
	  userService.deleteUser(id); 
	  return ResponseEntity.noContent().build(); 
	  }
	 
}
