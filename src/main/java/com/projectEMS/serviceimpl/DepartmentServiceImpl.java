package com.projectEMS.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectEMS.converter.DepartmentConverter;
import com.projectEMS.dao.DepartmentRepository;
import com.projectEMS.dto.DepartmentDTO;
import com.projectEMS.entities.Department;
import com.projectEMS.service.DepartmentService;

@Component
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private final DepartmentRepository departmentRepository;
    private final DepartmentConverter departmentConverter;
 
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    @Override
    public DepartmentDTO getDepartmentById(int id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return departmentConverter.entityToDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
            .map(departmentConverter::entityToDto)
            .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentConverter.dtoToEntity(departmentDTO);
        department = departmentRepository.save(department);
        return departmentConverter.entityToDto(department);
    }

    @Override
    public DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDTO) {
        Department department = departmentConverter.dtoToEntity(departmentDTO);
        department.setId(id);
        department = departmentRepository.save(department);
        return departmentConverter.entityToDto(department);
    }

    @Override
    public String deleteDepartment(int id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return "deleted";
        }else {
        return "not found";
        }
    }

}
