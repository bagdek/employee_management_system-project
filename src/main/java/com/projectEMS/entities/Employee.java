package com.projectEMS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_Details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee_ID")
	private int id;
	
	@NotNull(message="Firstname cannot be null")
	@Column(name="FirstName")
	private String firstname;
	
	@NotBlank (message="Lastname cannot be null")
	@Column(name="LastName")
	private String lastname;
	
	@Email(message="Enter proper email")
	@Column(name="Emp_Email")
	private String email;
	
	@NotEmpty(message="Gender cannot be null or empty")
	@Column(name="Emp_Gender")
	private String gender;
	
	@Min(18)
	@Max(40)
	@Column(name="Emp_Age")
	private int age;
	
	@ManyToOne
	@NotNull
    @JoinColumn(name="department_id")
    private Department department;
	
	@NotEmpty(message="jobrole name cannot be null or empty")
	@Column(name= "JobRole")
	private String jobrole;
	
	@NotNull(message="Enter monthly salary for this jobrole")
	@Column(name="SalaryperMonth")
	private int salary;
	
	@OneToOne
	@JoinColumn(name = "user_id") 
	@NotNull(message="Enter user id")
	private User user;


}
