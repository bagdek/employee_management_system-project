package com.projectEMS.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.projectEMS.dto.EmployeeDTO;
import com.projectEMS.entities.Department;
import com.projectEMS.entities.Employee;
import com.projectEMS.entities.User;

@Component
public class EmployeeConverter {
	 public EmployeeDTO entityToDto(Employee employee) {
	        EmployeeDTO employeeDTO = new EmployeeDTO();
	        employeeDTO.setId(employee.getId());
	        employeeDTO.setFirstname(employee.getFirstname());
	        employeeDTO.setLastname(employee.getLastname());
	        employeeDTO.setEmail(employee.getEmail());
	        employeeDTO.setGender(employee.getGender());
	        employeeDTO.setAge(employee.getAge());
	        employeeDTO.setDepartmentId(employee.getDepartment().getId());
	        employeeDTO.setJobrole(employee.getJobrole());
	        employeeDTO.setSalary(employee.getSalary());
	        employeeDTO.setUserId(employee.getUser().getId());
	        return employeeDTO;
	    }

	    public Employee dtoToEntity(EmployeeDTO employeeDTO) {
	        Employee employee = new Employee();
	        employee.setId(employeeDTO.getId());
	        employee.setFirstname(employeeDTO.getFirstname());
	        employee.setLastname(employeeDTO.getLastname());
	        employee.setEmail(employeeDTO.getEmail());
	        employee.setGender(employeeDTO.getGender());
	        employee.setAge(employeeDTO.getAge());
	       //Set department using the departmentId
	       Department department=new Department();
	       department.setId(employeeDTO.getDepartmentId());
	       employee.setDepartment(department);
	       employee.setJobrole(employeeDTO.getJobrole());
	       employee.setSalary(employeeDTO.getSalary());
	       //set user using userID
	       User user=new User();
	       user.setId(employeeDTO.getUserId());
	       employee.setUser(user);
	        return employee;
	    }

	    public List<EmployeeDTO> entityToDtoList(List<Employee> employees) {
	        return employees.stream()
	            .map(this::entityToDto)
	            .collect(Collectors.toList());
	    }

}
