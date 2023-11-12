package com.projectEMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectEMS.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin findAdminById(int id);

}
