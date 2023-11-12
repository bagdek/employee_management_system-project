package com.projectEMS.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.projectEMS.converter.UserConverter;
import com.projectEMS.dao.UserRepository;
import com.projectEMS.dto.UserDTO;
import com.projectEMS.entities.User;
import com.projectEMS.exception.UserNotFoundException;
import com.projectEMS.service.UserService;


@Component
public class UserServiceImpl implements UserService {
	
	  @Autowired 
	  private final UserRepository userRepository; 
	  private final
	  UserConverter userConverter;
	  
	  public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) { 
		  this.userRepository = userRepository; 
		  this.userConverter =userConverter; 
		  }
	  
	  @Override public UserDTO getUserById(int id) { 
		  User user = userRepository.findUserById(id); 
		  if (user == null) { // Corrected null check
	      throw new UserNotFoundException("User not found with id: " + id); 
	      } 
		  return userConverter.userToUserDTO(user); }
	  
	  @Override public UserDTO createUser(UserDTO userDTO) { 
		  User user = userConverter.userDTOToUser(userDTO); 
		  user = userRepository.save(user);
	      return userConverter.userToUserDTO(user); 
	      }
	  
	  @Override public UserDTO updateUser(int id, UserDTO userDTO) { 
		  User existingUser = userRepository.findUserById(id); 
		  if (existingUser == null) {
	    // Corrected null check throw new
	    throw new UserNotFoundException("User not found with id: " + id); 
	    }
	  
	     // Update user fields from userDTO
	  existingUser.setUsername(userDTO.getUsername());
	  existingUser.setPassword(userDTO.getPassword());
	  existingUser.setEmail(userDTO.getEmail());
	  
	  User updatedUser = userRepository.save(existingUser); return
	  userConverter.userToUserDTO(updatedUser); 
	  }
	  
	  @Override public void deleteUser(int id) { 
	  User user = userRepository.findUserById(id); 
	  if (user == null) { // Corrected null check
	  throw new UserNotFoundException("User not found with id: " + id); 
	  }
	  userRepository.delete(user); 
	  }
	  
	  @Override public List<UserDTO> getAllUsers() { 
	  List<User> users = userRepository.findAll(); 
	  return userConverter.usersToUserDTOs(users); 
	  }
	 
}