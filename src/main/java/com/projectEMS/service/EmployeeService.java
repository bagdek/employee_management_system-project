package com.projectEMS.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.projectEMS.dto.EmployeeDTO;
import com.projectEMS.exception.EmployeeNotFoundException;

@Service
public interface EmployeeService {
    EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException;
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(int id);
    List<EmployeeDTO> getAllEmployees();


}
