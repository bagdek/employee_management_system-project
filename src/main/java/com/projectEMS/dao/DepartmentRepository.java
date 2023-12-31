package com.projectEMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectEMS.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
