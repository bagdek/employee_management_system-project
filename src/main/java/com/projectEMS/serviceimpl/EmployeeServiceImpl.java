package com.projectEMS.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectEMS.converter.EmployeeConverter;
import com.projectEMS.dao.EmployeeRepository;
import com.projectEMS.dto.EmployeeDTO;
import com.projectEMS.entities.Employee;
import com.projectEMS.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	 @Autowired
	    private EmployeeConverter employeeConverter;
	    private EmployeeRepository employeeRepository;

	    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter) {
	        this.employeeRepository = employeeRepository;
	        this.employeeConverter = employeeConverter;
	    }

	    @Override
	    public EmployeeDTO getEmployeeById(int id){
	        Employee employee = employeeRepository.findById(id).orElse(null);
	        return employeeConverter.entityToDto(employee);
	    }

	    @Override
	    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
	        Employee employee = employeeConverter.dtoToEntity(employeeDTO);
	        employee = employeeRepository.save(employee);
	        return employeeConverter.entityToDto(employee);
	    }

	    @Override
	    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
	        Employee employee = employeeConverter.dtoToEntity(employeeDTO);
	        employee.setId(employeeDTO.getId());
	        employee = employeeRepository.save(employee);
	        return employeeConverter.entityToDto(employee);
	    }

	    @Override
	    public void deleteEmployee(int id) {
	        employeeRepository.deleteById(id);
	    }

	    @Override
	    public List<EmployeeDTO> getAllEmployees() {
	        List<Employee> employees = employeeRepository.findAll();
	        return employees.stream()
	            .map(employeeConverter::entityToDto)
	            .collect(Collectors.toList());
	    }
}
