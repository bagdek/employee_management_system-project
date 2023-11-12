package com.projectEMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectEMS.dto.DepartmentDTO;
@Service
public interface DepartmentService {
	
	DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
	DepartmentDTO getDepartmentById(int id);
	DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDTO);
    String deleteDepartment(int id);
    List<DepartmentDTO> getAllDepartments();
}
