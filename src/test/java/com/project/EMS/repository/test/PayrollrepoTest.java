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

import com.projectEMS.dao.PayrollDAO;
import com.projectEMS.entities.Payroll;
import com.projectEMS.service.PayrollService;


@SpringBootTest
public class PayrollrepoTest {
	@InjectMocks
    private PayrollDAO payrollDAO;

    @Mock
    private PayrollService payrollService;

    @Test
    public void testFindPayrollById() {
        // Create a sample Payroll entity and save it to the database
        int payrollId = 1;
        Payroll payroll = new Payroll();

     // Mock the behavior of the leaveRepository.findById method
        when(payrollDAO.findById(payrollId)).thenReturn(Optional.of(payroll));

        // Call the repository method to get a leave by ID
        Optional<Payroll> result = payrollDAO.findById(payrollId);

        // Verify that the service method was not called
        verify(payrollService, times(0)).getPayrollById(payrollId);
        
     // Assert that the returned Optional contains the expected Employee entity
        assertTrue(result.isPresent());
        assertEquals(payrollId, result.get().getId());

    }
}
