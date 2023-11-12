package com.projectEMS.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class DepartmentDTO {
	private int id;
	
	@NotEmpty(message="Department name cannot be null or empty")
	private String name;
	
	@NotNull(message="Enter description of department")
	private String description;

}
