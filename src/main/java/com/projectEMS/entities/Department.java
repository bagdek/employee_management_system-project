package com.projectEMS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Department_Details")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Department_ID")
	private int id;
	
	@NotEmpty(message="Department name cannot be null or empty")
	@Column(name = "Department_Name")
	private String name;
	
	@NotNull(message="Enter description of department")
	@Column(name = "Description")
	private String description;

}
