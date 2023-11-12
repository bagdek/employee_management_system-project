package com.projectEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectEMS.dto.PayrollDTO;
import com.projectEMS.service.PayrollService;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
	@Autowired
    private PayrollService payrollService;

	// Endpoint to create a payroll record
    @PostMapping("/create")
    public ResponseEntity<PayrollDTO> createPayroll(@RequestBody PayrollDTO payroll) {
        PayrollDTO createdPayroll = payrollService.createPayroll(payroll);
        return ResponseEntity.ok(createdPayroll);
    }
    
    @GetMapping("/get/all")
    public List<PayrollDTO> getAllPayrolls() {
        List<PayrollDTO> payrollDTOs = payrollService.getAllPayrolls();
        return payrollDTOs;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PayrollDTO> getPayroll(@PathVariable int id) {
    	PayrollDTO payrollDTO = payrollService.getPayrollById(id);
        if (payrollDTO != null) {
            return ResponseEntity.ok(payrollDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PayrollDTO> updatePayroll(@RequestBody PayrollDTO payrollDTO, @PathVariable int id) {
    	PayrollDTO updatedPayroll = payrollService.updatePayroll(id, payrollDTO);
        if (updatedPayroll != null) {
            return ResponseEntity.ok(updatedPayroll);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable int id) {
        String result = payrollService.deletePayroll(id);
        if (result.equals("deleted")) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
