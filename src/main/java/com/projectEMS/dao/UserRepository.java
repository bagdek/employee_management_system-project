package com.projectEMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectEMS.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
      
	User findUserById(int id);

}
