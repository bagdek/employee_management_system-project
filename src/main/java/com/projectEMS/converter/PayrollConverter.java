package com.projectEMS.converter;

import org.springframework.stereotype.Component;

import com.projectEMS.dto.PayrollDTO;
import com.projectEMS.entities.Employee;
import com.projectEMS.entities.Payroll;



@Component
public class PayrollConverter {
	public PayrollDTO convertToPayrollDTO(Payroll payroll) {
		PayrollDTO payrollDTO = new PayrollDTO();
		payrollDTO.setId(payroll.getId());
		payrollDTO.setEmployeeId(payroll.getEmployee().getId());
		payrollDTO.setBasesalary(payroll.getBasesalary());
		payrollDTO.setMonth(payroll.getMonth());
		payrollDTO.setLeavesTaken(payroll.getLeavesTaken());
		payrollDTO.setCalculatedsalary(payroll.getCalculatedsalary());
		return payrollDTO;
		}
  
	public Payroll convertToPayrollEntity (PayrollDTO payrollDTO){
	    Payroll	payroll = new Payroll();
	    payroll.setId(payrollDTO.getId());
	    //Set employee using the employeeId
        Employee employee = new Employee();
        employee.setId(payrollDTO.getEmployeeId());
        payroll.setEmployee(employee);
        
        payroll.setBasesalary(payrollDTO.getBasesalary());
        payroll.setMonth(payrollDTO.getMonth());
        payroll.setLeavesTaken(payrollDTO.getLeavesTaken());
        payroll.setCalculatedsalary(payrollDTO.getCalculatedsalary());
	    return payroll;    
 }
}

