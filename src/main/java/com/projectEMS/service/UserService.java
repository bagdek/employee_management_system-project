package com.projectEMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectEMS.dto.UserDTO;

@Service
public interface UserService {
	
	  UserDTO getUserById(int id);
	  
	  UserDTO createUser(UserDTO userDTO);
	  
	  UserDTO updateUser(int id, UserDTO userDTO);
	  
	  void deleteUser(int id);
	  
	  List<UserDTO> getAllUsers();
	 	

}
