package com.projectEMS.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectEMS.converter.PayrollConverter;
import com.projectEMS.dao.PayrollDAO;
import com.projectEMS.dto.PayrollDTO;
import com.projectEMS.entities.Payroll;
import com.projectEMS.service.PayrollService;


@Component
public class PayrollServiceImpl implements PayrollService {
	@Autowired
	private final PayrollDAO payrollDAO;
    private final PayrollConverter payrollConverter;
    
	
    
    public PayrollServiceImpl(PayrollDAO payrollDAO, PayrollConverter payrollConverter) {
        this.payrollDAO = payrollDAO;
        this.payrollConverter = payrollConverter;
        
    }
    @Override
    public PayrollDTO createPayroll(PayrollDTO payrollDTO) {
        Payroll payroll = payrollConverter.convertToPayrollEntity(payrollDTO);
        payroll.calculateSalary(); // Calculate salary before saving
        payroll = payrollDAO.save(payroll);
        return payrollConverter.convertToPayrollDTO(payroll);
    }
    @Override
    public PayrollDTO getPayrollById(int id) {
        Optional<Payroll> payroll = payrollDAO.findById(id);
        return payroll.map(payrollConverter::convertToPayrollDTO).orElse(null);
    }
    @Override
    public PayrollDTO updatePayroll(int id, PayrollDTO payrollDTO) {
        Payroll payroll = payrollConverter.convertToPayrollEntity(payrollDTO);
        payroll.setId(id);
        payroll.calculateSalary(); // Recalculate salary before updating
        payroll = payrollDAO.save(payroll);
        return payrollConverter.convertToPayrollDTO(payroll);
    }
    @Override
    public String deletePayroll(int id) {
    	payrollDAO.deleteById(id);
        return "Payroll with ID " + id + " has been deleted successfully.";
    }
    @Override
    public List<PayrollDTO> getAllPayrolls() {
        List<Payroll> payrolls = payrollDAO.findAll();
        return payrolls.stream().map(payrollConverter::convertToPayrollDTO).collect(Collectors.toList());
    }
	
}
