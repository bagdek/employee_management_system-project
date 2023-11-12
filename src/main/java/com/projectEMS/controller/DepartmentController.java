package com.projectEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projectEMS.dto.DepartmentDTO;
import com.projectEMS.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	 @Autowired
	    private DepartmentService departmentService;

	    @GetMapping("/get/all")
	    public List<DepartmentDTO> getAllDepartments() {
	        List<DepartmentDTO> departmentDTOs = departmentService.getAllDepartments();
	        return departmentDTOs;
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable int id) {
	        DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
	        if (departmentDTO != null) {
	            return ResponseEntity.ok(departmentDTO);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("/create")
	    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
	        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable int id) {
	        DepartmentDTO updatedDepartment = departmentService.updateDepartment(id, departmentDTO);
	        if (updatedDepartment != null) {
	            return ResponseEntity.ok(updatedDepartment);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteDepartmentByID(@PathVariable int id) {
	        String result = departmentService.deleteDepartment(id);
	        if (result.equals("deleted")) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
