package com.project.EMS.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectEMS.dao.EmployeeRepository;
import com.projectEMS.entities.Employee;
import com.projectEMS.exception.EmployeeNotFoundException;
import com.projectEMS.service.EmployeeService;

@SpringBootTest
public class EmployeerepoTest
{
	@InjectMocks
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeById() {
        // Create a sample Employee entity and ID
        int employeeId = 1;
        Employee employee = new Employee();

        // Mock the behavior of the employeeRepository.findById method
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        // Call the repository method to get an employee by ID
        Optional<Employee> result = employeeRepository.findById(employeeId);

        // Verify that the service method was not called
        try {
			verify(employeeService, times(0)).getEmployeeById(employeeId);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}

        // Assert that the returned Optional contains the expected Employee entity
        assertTrue(result.isPresent());
        assertEquals(employeeId, result.get().getId());
        assertEquals("Riya Arora", result.get().getFirstname());
        assertEquals("Riya Arora", result.get().getLastname());
    }
}
	

