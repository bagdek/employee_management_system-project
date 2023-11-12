package com.projectEMS.dto;

import javax.validation.constraints.NotNull;

import com.projectEMS.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class PayrollDTO {
    private int id;
	
	@NotNull
	private int employeeId;
	private Employee employee;

	@NotNull(message= "enter BaseSalary")
	private double basesalary;
	
	@NotNull(message= "enter month")
	private String month;
	
	@NotNull(message= "enter no. of leaves")
	private Integer leavesTaken;
	
	private double calculatedsalary;

}
 