package com.projectEMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectEMS.dto.PayrollDTO;

@Service
public interface PayrollService {
	PayrollDTO createPayroll(PayrollDTO payrollDTO);
    PayrollDTO getPayrollById(int id);
    PayrollDTO updatePayroll(int id, PayrollDTO payrollDTO);
    String deletePayroll(int id);
    List<PayrollDTO> getAllPayrolls();
	
}

