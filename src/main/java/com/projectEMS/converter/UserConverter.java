package com.projectEMS.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.projectEMS.dto.UserDTO;
import com.projectEMS.entities.User;

@Component
public class UserConverter {
	public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        return users.stream()
                .map(this::userToUserDTO)
                .collect(Collectors.toList());
    }
	

}
