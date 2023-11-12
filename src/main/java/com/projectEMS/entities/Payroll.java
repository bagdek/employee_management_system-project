package com.projectEMS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payroll_Details")
public class Payroll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Payroll_ID")
    private int id;
	    
	@ManyToOne
	@NotNull(message= "enter employee Id")
	@JoinColumn(name = "Employee_ID")
    private Employee employee;
	
	@NotNull(message= "enter BaseSalary")
	@Column(name="BaseSalary")
    private double basesalary;
	
	@NotNull(message= "enter month")
	@Column(name="Month")
    private String month;
	
	@NotNull(message= "enter no. of leaves")
	@Column(name = "Leaves_taken")
    private Integer leavesTaken;  // New field for leaves
	
	@Column(name="TotalSalary")
    private double calculatedsalary;
	
	// Additional method to calculate salary based on leaves
	public void calculateSalary() {
	    System.out.println("Base Salary: " + basesalary);
	    System.out.println("Leaves Taken: " + leavesTaken);
	    
	    double dailyRate = (double) basesalary / 30.0;
	    System.out.println("Daily Rate: " + dailyRate);
	    
	    double leaveDeduction = leavesTaken * dailyRate;
	    System.out.println("Leave Deduction: " + leaveDeduction);
	    
	    calculatedsalary = basesalary - leaveDeduction;
	    System.out.println("Calculated Salary: " + calculatedsalary);
	}
}
 