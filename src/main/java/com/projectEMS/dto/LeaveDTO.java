package com.projectEMS.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.projectEMS.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class LeaveDTO {
	private int id;
	
	@NotNull
	private int employeeId;
	private Employee employee;
	
	@NotEmpty(message="Enter reason")
	private String reason;
	
	@NotNull (message="Enter date")
	private LocalDate startDate;
	
	@NotNull (message="Enter date")
	private LocalDate endDate;
	
	@NotNull(message="Enter status")
	private String status;
	
    private int calculatedLeaves;


}
